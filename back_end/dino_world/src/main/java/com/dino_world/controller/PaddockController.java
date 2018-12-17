package com.dino_world.controller;

import com.dino_world.models.Paddock;
import com.dino_world.repositories.paddocks.PaddockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paddocks")
public class PaddockController {

    @Autowired
    PaddockRepository paddockRepository;

    @GetMapping(value = "/all")
    public List<Paddock> allPadocks(){
        return paddockRepository.allPaddocks();
    }
}
