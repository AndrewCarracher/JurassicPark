package com.dino_world.repositories.paddocks;

import com.dino_world.models.Dinosaur;
import com.dino_world.models.Paddock;

import java.util.List;

public interface PaddockRepositoryCustom {
    List<Paddock> allPaddocks();
    int freeSpace(String paddockName);
    public Long checkNewDinosaur(Dinosaur dinosaur);
    void addNewDinosaur(String dinosaurName, int dinosaurAge, String dinosaurSpecies, boolean fed, boolean eatsMeat);
    Dinosaur removeDinosaur(String name, String species, String paddockName);
    Paddock getFreePaddock(boolean containsCarnivores);
}
