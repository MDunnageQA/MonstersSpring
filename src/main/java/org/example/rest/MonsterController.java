package org.example.rest;

import org.example.domain.Monsters;
import org.example.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonsterController {

    private final MonsterService service;

    @Autowired
    public MonsterController(MonsterService service){
        this.service = service;
    }

    @GetMapping("/getAllMonsters")
    public List<Monsters> getAllMonsters(){
        return this.service.readMonsters();
    }
}
