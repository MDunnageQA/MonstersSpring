package org.example.rest;

import org.example.domain.Power;
import org.example.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PowerController {

    private final PowerService service;

    @Autowired
    public PowerController(PowerService service){
        this.service = service;
    }

    @GetMapping("/getAllPowers")
    public List<Power> getAllPowers(){
        return this.service.readPowers();
    }

}
