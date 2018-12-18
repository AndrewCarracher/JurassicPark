package com.dino_world.controller;

import com.dino_world.models.Park;
import com.dino_world.repositories.parks.ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ParkController {

    @Autowired
    ParkRepository parkRepository;

    @GetMapping(value = "/park")
    public List<Park> allParks(){
        return parkRepository.allParks();
    }

    @GetMapping(value = "/park/add_customer/{time}")
    public void addVisitors(@PathVariable int time){
        parkRepository.addVisitors(time);
    }

    @GetMapping(value = "/park/close_park")
    public void emptyPark(){
        parkRepository.removeAllVisitors();
    }

    @GetMapping(value = "park/transfer_dino/{dino_name}/{pen_from_name}/{pen_to_name}")
    public void transferDino(@PathVariable String dinoName,@PathVariable String penFromName, @PathVariable String penToName){
        parkRepository.transferDino(dinoName, penFromName, penToName);
    }
}
