package com.dino_world.controller;

import com.dino_world.models.Dinosaur;
import com.dino_world.models.Paddock;
import com.dino_world.repositories.dinosaurs.DinosaurRepository;
import com.dino_world.repositories.paddocks.PaddockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paddocks")
public class PaddockController {

    @Autowired
    PaddockRepository paddockRepository;

    @Autowired
    DinosaurRepository dinosaurRepository;

    @GetMapping(value = "/all")
    public List<Paddock> allPadocks(){
        return paddockRepository.allPaddocks();
    }

    @PostMapping(path = "/add_dino", produces = "application/json")
    public void addDinosaurToPaddock(@RequestBody Dinosaur dino){

        Paddock paddock = paddockRepository.getFreePaddock(dino.isEatsMeat());
            paddock.addDinosaur(dino);
            dino.setPaddock(paddock);
            paddockRepository.save(paddock);
            dinosaurRepository.save(dino);
    }

    @DeleteMapping(path = "/kill_dino/{id}", produces = "application/json")
    public void removeDinosaur(@PathVariable Long id){
        Dinosaur dino = dinosaurRepository.getOne(id);
        dinosaurRepository.delete(dino);
    }
}
