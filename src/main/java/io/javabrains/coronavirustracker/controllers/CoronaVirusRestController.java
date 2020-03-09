package io.javabrains.coronavirustracker.controllers;

import io.javabrains.coronavirustracker.models.LocationStats;
import io.javabrains.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoronaVirusRestController {
    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/get")
    public List<LocationStats> getCoronaVirusData(){
        return coronaVirusDataService.getAllStats();
    }
}
