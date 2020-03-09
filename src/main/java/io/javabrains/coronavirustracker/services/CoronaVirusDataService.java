package io.javabrains.coronavirustracker.services;

import io.javabrains.coronavirustracker.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusDataService {
    private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";

    private List<LocationStats> locationStatsList = new ArrayList<>();
    @PostConstruct
    @Scheduled(cron = "* * 1 * * *") //second,minute,hour,day,month,year
    public void fetchVirusData() throws IOException, InterruptedException {
        List<LocationStats> newStat = new ArrayList<>();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VIRUS_DATA_URL))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

//        System.out.println(httpResponse.body());

        StringReader stringReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);
        for(CSVRecord record : records){
            LocationStats locationStats = new LocationStats();
            locationStats.setCountry(record.get("Country/Region"));
            locationStats.setState(record.get("Province/State"));
            locationStats.setLatestTotalCases(Integer.parseInt(record.get(record.size()-1)));
            int latestCases = Integer.parseInt(record.get(record.size()-1));
            int previusDayCases = Integer.parseInt(record.get(record.size()-2));
            locationStats.setDiffFromPrevDay(latestCases-previusDayCases);
            System.out.println(locationStats);
            newStat.add(locationStats);
        }
        this.locationStatsList = newStat;
    }

    public List<LocationStats> getAllStats(){
        return locationStatsList;
    }
}
