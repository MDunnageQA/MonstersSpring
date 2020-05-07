package com.qa.rest;

import com.qa.domain.Monsters;
import com.qa.service.MonsterService;
import com.qa.dto.MonsterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MonsterDTO>> getAllMonsters(){
        return ResponseEntity.ok(this.service.readMonsters());
    }

    @PostMapping("/createMonsters")
    public ResponseEntity<MonsterDTO> createMonsters(@RequestBody Monsters monsters){
        return new ResponseEntity<MonsterDTO>(this.service.createMonsters(monsters), HttpStatus.CREATED);
    }

    @GetMapping("/getMonstersByID/{id}")
    public ResponseEntity<MonsterDTO> getMonstersByID(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findMonstersByID(id));
    }

    @PutMapping("/updateMonsters/{id}")
    public ResponseEntity<MonsterDTO> updateMonsters(@PathVariable Long id, @RequestBody Monsters monsters){
        return ResponseEntity.ok(this.service.findMonstersByID(id));
    }

    @DeleteMapping("/deleteMonsters/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id){
        return this.service.deleteMonsters(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

}
