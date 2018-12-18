package com.dino_world.controller;

import com.dino_world.models.Dinosaur;
import com.dino_world.models.Paddock;
import com.dino_world.repositories.paddocks.PaddockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value = "check_space/{name}")
    public int freeSpace(@PathVariable String name){
        return paddockRepository.freeSpace(name);
    }

    @GetMapping(value = "check_compatibility/{dino_name}/{paddock_name}")
    public boolean checkCompatibility(@PathVariable String dinosaurName, @PathVariable String paddockName){
        return paddockRepository.checkCompatibility(dinosaurName, paddockName);
    }

   @GetMapping(value = "add_dino/{dino_name/{paddock_name}")
   public void addDinosaur(@PathVariable String dinosaurName, @PathVariable String paddockName){
        paddockRepository.addDinosaur(dinosaurName, paddockName);
   }

   @GetMapping(value = "remove_dino/{dino_name}/{dino_type}/{paddock_name}")
   public Dinosaur removeDinosaur(@PathVariable String name, @PathVariable String type, @PathVariable String paddockName){
        return paddockRepository.removeDinosaur(name, type, paddockName);
   }
}
