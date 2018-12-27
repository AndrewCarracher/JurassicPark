package com.dino_world.components;

import com.dino_world.models.Dinosaur;
import com.dino_world.models.Paddock;
import com.dino_world.models.Park;
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

        Paddock paddock1 = new Paddock(30, "paddock1", dinoWorld, false);
        paddockRepository.save(paddock1);

        Paddock paddock2 = new Paddock(30, "paddock2", dinoWorld, false);
        paddockRepository.save(paddock2);

        Paddock paddock3 = new Paddock(30, "paddock3", dinoWorld, false);
        paddockRepository.save(paddock3);

        Paddock paddock4 = new Paddock(30, "paddock4", dinoWorld, false);
        paddockRepository.save(paddock4);

        Paddock paddock5 = new Paddock(30, "paddock5", dinoWorld, false);
        paddockRepository.save(paddock5);

        Paddock paddock6 = new Paddock(30, "paddock6", dinoWorld, false);
        paddockRepository.save(paddock6);












        Dinosaur dino1 = new Dinosaur("frank", "raptor", 6, false, true);
        dino1.setPaddock(paddock1);
        dinosaurRepository.save(dino1);
        paddock1.setContainsCarnivores(true);
        paddockRepository.save(paddock1);

        Dinosaur dino2 = new Dinosaur("murph", "raptor", 5, false, true);
        dino2.setPaddock(paddock1);
        dinosaurRepository.save(dino2);
        paddock1.setContainsCarnivores(true);
        paddockRepository.save(paddock1);

        Dinosaur dino3 = new Dinosaur("topher", "raptor", 4, false, true);
        dino3.setPaddock(paddock1);
        dinosaurRepository.save(dino3);
        paddock1.setContainsCarnivores(true);
        paddockRepository.save(paddock1);

        Dinosaur dino4 = new Dinosaur("dino", "raptor", 10, false, true);
        dino4.setPaddock(paddock1);
        dinosaurRepository.save(dino4);
        paddock1.setContainsCarnivores(true);
        paddockRepository.save(paddock1);

        Dinosaur dino5 = new Dinosaur("bruce", "t-rex", 6, false, true);
        dino5.setPaddock(paddock2);
        dinosaurRepository.save(dino5);
        paddock2.setContainsCarnivores(true);
        paddockRepository.save(paddock2);

        Dinosaur dino6 = new Dinosaur("martha", "t-rex", 6, false, true);
        dino6.setPaddock(paddock2);
        dinosaurRepository.save(dino6);
        paddock2.setContainsCarnivores(true);
        paddockRepository.save(paddock2);

        Dinosaur dino7 = new Dinosaur("lee", "t-rex", 6, false, true);
        dino7.setPaddock(paddock2);
        dinosaurRepository.save(dino7);
        paddock2.setContainsCarnivores(true);
        paddockRepository.save(paddock2);

        Dinosaur dino8 = new Dinosaur("franco", "t-rex", 6, false, true);
        dino8.setPaddock(paddock2);
        dinosaurRepository.save(dino8);
        paddock2.setContainsCarnivores(true);
        paddockRepository.save(paddock2);

        Dinosaur dino9 = new Dinosaur("belle", "pterodactyl", 6, false, true);
        dino9.setPaddock(paddock3);
        dinosaurRepository.save(dino9);
        paddock3.setContainsCarnivores(true);
        paddockRepository.save(paddock3);

        Dinosaur dino10 = new Dinosaur("margret", "pterodactyl", 6, false, true);
        dino10.setPaddock(paddock3);
        dinosaurRepository.save(dino10);
        paddock3.setContainsCarnivores(true);
        paddockRepository.save(paddock3);

        Dinosaur dino11 = new Dinosaur("penelope", "pterodactyl", 6, false, true);
        dino11.setPaddock(paddock3);
        dinosaurRepository.save(dino11);
        paddock3.setContainsCarnivores(true);
        paddockRepository.save(paddock3);

        Dinosaur dino12 = new Dinosaur("monty", "pterodactyl", 6, false, true);
        dino12.setPaddock(paddock3);
        dinosaurRepository.save(dino12);
        paddock3.setContainsCarnivores(true);
        paddockRepository.save(paddock3);

        Dinosaur dino13 = new Dinosaur("darcy", "diplodocus", 6, false, false);
        dino13.setPaddock(paddock4);
        dinosaurRepository.save(dino13);
        paddock4.setContainsCarnivores(false);
        paddockRepository.save(paddock4);

        Dinosaur dino14 = new Dinosaur("brett", "diplodocus", 6, false, false);
        dino14.setPaddock(paddock4);
        dinosaurRepository.save(dino14);
        paddock4.setContainsCarnivores(false);
        paddockRepository.save(paddock4);

        Dinosaur dino15 = new Dinosaur("chad", "diplodocus", 6, false, false);
        dino15.setPaddock(paddock4);
        dinosaurRepository.save(dino15);
        paddock4.setContainsCarnivores(false);
        paddockRepository.save(paddock4);

        Dinosaur dino16 = new Dinosaur("brad", "diplodocus", 6, false, false);
        dino16.setPaddock(paddock4);
        dinosaurRepository.save(dino16);
        paddock4.setContainsCarnivores(false);
        paddockRepository.save(paddock4);

        Dinosaur dino17 = new Dinosaur("dexter", "diplodocus", 6, false, false);
        dino17.setPaddock(paddock4);
        dinosaurRepository.save(dino17);
        paddock4.setContainsCarnivores(false);
        paddockRepository.save(paddock4);

        Dinosaur dino18 = new Dinosaur("jack", "diplodocus", 6, false, false);
        dino18.setPaddock(paddock4);
        dinosaurRepository.save(dino18);
        paddock4.setContainsCarnivores(false);
        paddockRepository.save(paddock4);

        Dinosaur dino19 = new Dinosaur("billy", "stegosaurus", 6, false, false);
        dino19.setPaddock(paddock5);
        dinosaurRepository.save(dino19);
        paddock5.setContainsCarnivores(false);
        paddockRepository.save(paddock5);

        Dinosaur dino20 = new Dinosaur("ted", "stegosaurus", 6, false, false);
        dino20.setPaddock(paddock5);
        dinosaurRepository.save(dino20);
        paddock5.setContainsCarnivores(false);
        paddockRepository.save(paddock5);

        Dinosaur dino21 = new Dinosaur("beavus", "stegosaurus", 6, false, false);
        dino21.setPaddock(paddock5);
        dinosaurRepository.save(dino21);
        paddock5.setContainsCarnivores(false);
        paddockRepository.save(paddock5);

        Dinosaur dino22 = new Dinosaur("kurby", "stegosaurus", 6, false, false);
        dino22.setPaddock(paddock5);
        dinosaurRepository.save(dino22);
        paddock5.setContainsCarnivores(false);
        paddockRepository.save(paddock5);

        Dinosaur dino23 = new Dinosaur("len", "stegosaurus", 6, false, false);
        dino23.setPaddock(paddock5);
        dinosaurRepository.save(dino23);
        paddock5.setContainsCarnivores(false);
        paddockRepository.save(paddock5);

        Dinosaur dino24 = new Dinosaur("harry", "stegosaurus", 6, false, false);
        dino24.setPaddock(paddock5);
        dinosaurRepository.save(dino24);
        paddock5.setContainsCarnivores(false);
        paddockRepository.save(paddock5);

        Dinosaur dino25 = new Dinosaur("george", "stegosaurus", 6, false, false);
        dino25.setPaddock(paddock5);
        dinosaurRepository.save(dino25);
        paddock5.setContainsCarnivores(false);
        paddockRepository.save(paddock5);

        Dinosaur dino26 = new Dinosaur("mark", "triceratops", 6, false, false);
        dino26.setPaddock(paddock6);
        dinosaurRepository.save(dino26);
        paddock6.setContainsCarnivores(false);
        paddockRepository.save(paddock6);

        Dinosaur dino27 = new Dinosaur("steven", "triceratops", 6, false, false);
        dino27.setPaddock(paddock6);
        dinosaurRepository.save(dino27);
        paddock6.setContainsCarnivores(false);
        paddockRepository.save(paddock6);

        Dinosaur dino28 = new Dinosaur("david", "triceratops", 6, false, false);
        dino28.setPaddock(paddock6);
        dinosaurRepository.save(dino28);
        paddock6.setContainsCarnivores(false);
        paddockRepository.save(paddock6);

        Dinosaur dino29 = new Dinosaur("graham", "triceratops", 6, false, false);
        dino29.setPaddock(paddock6);
        dinosaurRepository.save(dino29);
        paddock6.setContainsCarnivores(false);
        paddockRepository.save(paddock6);

        Dinosaur dino30 = new Dinosaur("tina", "triceratops", 6, false, false);
        dino30.setPaddock(paddock6);
        dinosaurRepository.save(dino30);
        paddock6.setContainsCarnivores(false);
        paddockRepository.save(paddock6);

    }
}
