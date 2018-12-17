package com.dino_world.repositories.paddocks;

import com.dino_world.models.Dinosaur;
import com.dino_world.models.Paddock;

import java.util.List;

public interface PaddockRepositoryCustom {
    List<Paddock> allPaddocks();
    int freeSpace(String paddockName);
    boolean checkCompatibility(String dinosaurName, String paddockName);
    void addDinosaur(String dinosaurName, String paddockName);
    Dinosaur removeDinosaur(String name, String type, String paddockName);
}
