package org.example.rest;

import org.example.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerController {

    private final PowerService service;

    @Autowired
    public PowerController(PowerService service){
        this.service = service;
    }

}
