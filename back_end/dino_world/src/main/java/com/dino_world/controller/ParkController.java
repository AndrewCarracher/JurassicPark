package com.dino_world.controller;

import com.dino_world.models.Dinosaur;
import com.dino_world.models.Paddock;
import com.dino_world.models.Park;
import com.dino_world.repositories.dinosaurs.DinosaurRepository;
import com.dino_world.repositories.paddocks.PaddockRepository;
import com.dino_world.repositories.parks.ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ParkController {

    @Autowired
    ParkRepository parkRepository;

    @Autowired
    PaddockRepository paddockRepository;

    @Autowired
    DinosaurRepository dinosaurRepository;

    @GetMapping(value = "/park")
    public List<Park> allParks(){
        return parkRepository.allParks();
    }

    @PutMapping(value = "/park/transfer_dino/{dinoId}/{penToId}", produces = "application/json")
    public String transferDino(@PathVariable Long dinoId, @PathVariable Long penToId){
        Dinosaur dino = dinosaurRepository.getOne(dinoId);
        Paddock paddockTo = paddockRepository.getOne(penToId);

        if(paddockTo.isContainsCarnivores() == dino.isEatsMeat()){
            if(paddockTo.getCapacity() - paddockTo.getOccupants().size() > 0) {
                dino.setPaddock(paddockTo);
                dinosaurRepository.save(dino);
                paddockRepository.save(paddockTo);

                return "Transfer successful";
            }

            return "Paddock too small";
        }

        return "Transfer failed due to Carnivore/Herbivore";
    }

    @PostMapping(value = "/park/add_visitor")
    public void addVisitor(){
        parkRepository.addVisitor();
    }

    @PostMapping(value = "/park/remove_all_visitors")
    public void removeVisitors(){
        parkRepository.removeAllVisitors();
    }

    @PostMapping(value = "/park/change_park_open")
    public void changeOpenStatus(){
        parkRepository.changeParkOpen();
    }

    @PostMapping(value = "park/change_rampage")
    public void changeRampage(){
        parkRepository.changeRampage();
    }
}
