package com.dino_world.repositories.paddocks;

import com.dino_world.models.Dinosaur;
import com.dino_world.models.Paddock;

import java.util.List;

public interface PaddockRepositoryCustom {
    List<Paddock> allPaddocks();
    int freeSpace(Paddock paddock);
    boolean checkCompatibility(Dinosaur dinosaur, Paddock paddock);
    void addDinosaur(Dinosaur dinosaur, Paddock paddock);
    Dinosaur removeDinosaur(String name, String type, Paddock paddock);
}
