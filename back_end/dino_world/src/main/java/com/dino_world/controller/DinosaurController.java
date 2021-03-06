package com.dino_world.controller;

import com.dino_world.models.Dinosaur;
import com.dino_world.repositories.dinosaurs.DinosaurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/dinosaurs")
public class DinosaurController {
    @Autowired
    DinosaurRepository dinosaurRepository;

    @GetMapping(value = "/")
    public List<Dinosaur> allDinosaurs(){
        return dinosaurRepository.allDinosaurs();
    }

    @GetMapping(value = "/{name}")
    public List<Dinosaur> getDinosaurByName(@PathVariable String name){
        return dinosaurRepository.getDinosaurByName(name);
    }

    @GetMapping(value = "/feed/{name}")
    public void feedDinosaur(@PathVariable String name){
        dinosaurRepository.feedDinosaur(name);
    }
}
