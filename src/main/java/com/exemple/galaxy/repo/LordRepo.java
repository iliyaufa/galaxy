package com.exemple.galaxy.repo;

import com.exemple.galaxy.entity.Lord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LordRepo extends CrudRepository<Lord,Long> {
    List findByName(String name);
}
