package org.example.service;

import org.example.domain.Power;
import org.example.dto.PowerDTO;
import org.example.repository.PowerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PowerService {

    private final PowerRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public PowerService(PowerRepository repo, ModelMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    private PowerDTO mapToDTO(Power power){
        return this.mapper.map(power, PowerDTO.class);
    }

    public List<PowerDTO> readPowers(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }


    public PowerDTO createPowers(Power power){
        return this.mapToDTO(this.repo.save(power));
    }

}
