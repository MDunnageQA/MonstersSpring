package org.example.service;

import org.example.domain.Monsters;
import org.example.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonsterService {

    private final MonsterRepository repo;

    @Autowired
    public MonsterService(MonsterRepository repo){
        this.repo = repo;
    }

    public List<Monsters> readMonsters(){
        return this.repo.findAll();
    }

    public Monsters createMonsters(Monsters, monsters){
        return this.repo.save(Monsters);
    }

}
