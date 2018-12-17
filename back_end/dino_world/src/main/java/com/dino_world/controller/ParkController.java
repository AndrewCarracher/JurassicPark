package com.dino_world.controller;

import com.dino_world.models.Park;
import com.dino_world.repositories.parks.ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ParkController {

    @Autowired
    ParkRepository parkRepository;

    @GetMapping(value = "/")
    public List<Park> allParks(){
        return parkRepository.allParks();
    }
}
