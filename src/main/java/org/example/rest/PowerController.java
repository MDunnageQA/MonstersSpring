package org.example.rest;

import org.example.domain.Power;
import org.example.dto.PowerDTO;
import org.example.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PowerController {

    private final PowerService service;

    @Autowired
    public PowerController(PowerService service){
        this.service = service;
    }

    @GetMapping("/getAllPowers")
    public ResponseEntity <List<PowerDTO>> getAllPowers(){
        return ResponseEntity.ok(this.service.readPowers());
    }

    @PostMapping("/createPowers")
    public ResponseEntity<PowerDTO> createPowers(@RequestBody Power power){
        return new ResponseEntity<PowerDTO>(this.service.createPowers(power), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePowers/{id}")
    public ResponseEntity<?> deleteMonster(@PathVariable Long id){
        return this.service.deletePowers(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getPowersById/{id}")
    public ResponseEntity<PowerDTO> getNoteById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findPowersById(id));
    }

    @PutMapping("/updatePowers/{id}")
    public ResponseEntity<PowerDTO> updateNote(@PathVariable Long id, @RequestBody Power power){
        return ResponseEntity.ok(this.service.updatePowers(id, power));
    }

}
