package com.exemple.galaxy.controller;

import com.exemple.galaxy.entity.Planet;
import com.exemple.galaxy.service.PlanetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static java.lang.Integer.parseInt;

@Controller
public class PlanetController {
    private final PlanetService planetService;

    public PlanetController(PlanetService planetService){
        this.planetService = planetService;
    }
    @GetMapping
    public String main( Map<String,Object> model) {
        Iterable<Planet> planets = planetService.findAll();
        model.put("planets", planets);
        return "planets";
    }
    @PostMapping
    public String addPlanet(@RequestParam String name, Map<String,Object> model){
        if(name != null && name.isEmpty()){
                Planet planet = new Planet(name);
                planetService.save(planet);
                Iterable<Planet> planets = planetService.findAll();
                model.put("planets", planets);
                return "main";
        }else return "planets";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String,Object> model){
        Iterable<Planet> planets;
        if(filter != null && !filter.isEmpty() ){
            planets = planetService.findByName(filter);
        }else {
            planets = planetService.findAll();
        }
        model.put("planets", planets);
        return "planets";
    }
}
