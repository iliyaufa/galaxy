package com.exemple.galaxy.service;

import com.exemple.galaxy.entity.Lord;
import com.exemple.galaxy.entity.Planet;
import com.exemple.galaxy.repo.PlanetRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PlanetService {
    private final PlanetRepo planetRepo;

    public PlanetService(PlanetRepo planetRepo){
        this.planetRepo = planetRepo;
    }

    public Iterable<Planet> findAll(){
        Set<Planet> planets = new HashSet<>();
        planets = (Set<Planet>) planetRepo.findAll();
        return planets;
    }

    public void save(Planet planet){
        planetRepo.save(planet);
    }
    public Iterable<Planet> findByName(String name){
        return planetRepo.findByName(name);
    }
}
