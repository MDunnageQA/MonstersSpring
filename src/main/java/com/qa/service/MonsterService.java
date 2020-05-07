package com.qa.service;

import com.qa.domain.Monsters;
import com.qa.exceptions.MonsterNofFoundException;
import com.qa.repository.MonsterRepository;
import com.qa.dto.MonsterDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonsterService {

    private final MonsterRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public MonsterService(MonsterRepository repo, ModelMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    private MonsterDTO mapToDTO(Monsters monsters) {
        return this.mapper.map(monsters, MonsterDTO.class);
    }

    public List<MonsterDTO> readMonsters(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public MonsterDTO createMonsters(Monsters monsters){
        Monsters tempMonsters = this.repo.save(monsters);
        return this.mapToDTO(tempMonsters);
    }

    public MonsterDTO findMonstersByID(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(MonsterNofFoundException::new));
    }

    public MonsterDTO updateMonsters(Long id, Monsters monsters){
        Monsters update = this.repo.findById(id).orElseThrow(MonsterNofFoundException::new);
        update.setName(monsters.getName());
        update.setCategory(monsters.getCategory());
        update.setDescription(monsters.getDescription());
        Monsters tempMonsters = this.repo.save(monsters);
        return this.mapToDTO(tempMonsters);
    }

    public boolean deleteMonsters(Long id){
        if(!this.repo.existsById(id)){
            throw new MonsterNofFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
