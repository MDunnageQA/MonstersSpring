package org.example.rest;

import org.example.domain.Monsters;
import org.example.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/createMonsters")
    public Monsters createMonsters(@RequestBody Monsters monsters){
        return this.service.createMonsters(monsters);
    }

    @GetMapping("/getMonstersByID/{id}")
    public Monsters getMonstersByID(@PathVariable Long id){
        return this.service.findMonstersByID(id);
    }

    @PutMapping("/updateMonsters/{id}")
    public Monsters updateMonsters(@PathVariable Long id, @RequestBody Monsters monsters){
        return this.service.updateMonsters(id, monsters);
    }

}
