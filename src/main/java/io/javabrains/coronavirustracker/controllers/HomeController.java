package io.javabrains.coronavirustracker.controllers;

import io.javabrains.coronavirustracker.entities.Greetings;
import io.javabrains.coronavirustracker.models.LocationStats;
import io.javabrains.coronavirustracker.repo.GreetingsRepository;
import io.javabrains.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    private final GreetingsRepository greetingsRepository;

    @Autowired
    public HomeController(GreetingsRepository greetingsRepository) {
        this.greetingsRepository = greetingsRepository;
    }

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalDiffFromPrevDay = allStats.stream()
                .mapToInt(locationStats -> locationStats.getDiffFromPrevDay())
                .sum();

        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalDiffFromPrevDay", totalDiffFromPrevDay);
        model.addAttribute("testName", "Arfin");
        return "home";
    }

    @ResponseBody
    @GetMapping("/greetings")
    public List<Greetings> greetings(){
        return greetingsRepository.findAll();
    }
}
