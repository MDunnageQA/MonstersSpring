package org.example.service;

import org.example.domain.Power;
import org.example.repository.PowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerService {

    private final PowerRepository repo;


    @Autowired
    public PowerService(PowerRepository repo){
        this.repo = repo;
    }

public List<Power> readPowers(){
        return this.repo.findAll();
}

}
