package com.exemple.galaxy.repo;

import com.exemple.galaxy.entity.Planet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepo extends CrudRepository<Planet,Long> {

    Iterable<Planet> findByName(String name);
}
