package org.example.service;

import org.example.domain.Monsters;
import org.example.exceptions.MonsterNofFoundException;
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

    public Monsters createMonsters(Monsters monsters){
        return this.repo.save(monsters);
    }

    public Monsters findMonstersByID(Long id){
        return this.repo.findById(id).orElseThrow(MonsterNofFoundException::new);
    }

    public Monsters updateMonsters(Long id, Monsters monsters){
        Monsters update = findMonstersByID(id);
        update.setName(monsters.getName());
        update.setCategory(monsters.getCategory());
        update.setDescription(monsters.getDescription());
        return this.repo.save(update);
    }
}
