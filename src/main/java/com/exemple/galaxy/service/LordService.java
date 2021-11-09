package com.exemple.galaxy.service;

import com.exemple.galaxy.entity.Lord;
import com.exemple.galaxy.repo.LordRepo;
import org.springframework.stereotype.Service;

@Service
public class LordService {
    private LordRepo lordRepo;

    public LordService (LordRepo lordRepo){
        this.lordRepo = lordRepo;
    }
    public void save (Lord lord){
        lordRepo.save(lord);
    }
    public Iterable<Lord> findAll(){
        Iterable<Lord> lords = lordRepo.findAll();
        return lords;
    }
    public Iterable<Lord> findByName(String name){
        return lordRepo.findByName(name);
    }
}
