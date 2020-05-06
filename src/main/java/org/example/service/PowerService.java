package org.example.service;

import org.example.domain.Power;
import org.example.dto.PowerDTO;
import org.example.repository.PowerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerService {

    private final PowerRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public PowerService(PowerRepository repo, ModelMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    private PowerDTO mapToDo(Power power){
        return this.mapper.map(power, PowerDTO.class);
    }

    public List<Power> readPowers(){
        return this.repo.findAll();
    }


    public Power createPowers(Power power){
        return this.repo.save(power);
    }

}
