package com.dino_world.components;

import com.dino_world.models.Dinosaur;
import com.dino_world.models.Paddock;
import com.dino_world.models.Park;
import com.dino_world.models.Visitor;
import com.dino_world.repositories.dinosaurs.DinosaurRepository;
import com.dino_world.repositories.paddocks.PaddockRepository;
import com.dino_world.repositories.parks.ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ParkRepository parkRepository;

    @Autowired
    PaddockRepository paddockRepository;

    @Autowired
    DinosaurRepository dinosaurRepository;

    public DataLoader() {
    }


    public void run(ApplicationArguments args) {

        Park dinoWorld = new Park(0, 15000, true, 9, 20, false);
        parkRepository.save(dinoWorld);

        Paddock paddock1 = new Paddock(30, "paddock1", dinoWorld);
        paddockRepository.save(paddock1);

        Paddock paddock2 = new Paddock(30, "paddock2", dinoWorld);
        paddockRepository.save(paddock2);

        Paddock paddock3 = new Paddock(30, "paddock3", dinoWorld);
        paddockRepository.save(paddock3);

        Paddock paddock4 = new Paddock(30, "paddock4", dinoWorld);
        paddockRepository.save(paddock4);

        Paddock paddock5 = new Paddock(30, "paddock5", dinoWorld);
        paddockRepository.save(paddock5);

        Paddock paddock6 = new Paddock(30, "paddock6", dinoWorld);
        paddockRepository.save(paddock6);

        Dinosaur dino1 = new Dinosaur("frank", "raptor", 6, false, true, paddock1);
        dinosaurRepository.save(dino1);
        paddock1.setContainsCarnivores(true);
        paddockRepository.save(paddock1);

        Visitor visitor = new Visitor();
        parkRepository.addVisitors(11);

    }
}
