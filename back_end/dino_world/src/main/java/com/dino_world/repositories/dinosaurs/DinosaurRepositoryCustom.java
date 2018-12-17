package com.dino_world.repositories.dinosaurs;

import com.dino_world.models.Dinosaur;

import java.util.List;

public interface DinosaurRepositoryCustom {
    List<Dinosaur> allDinosaurs();
    void feedDinosaurs(Dinosaur dinosaur);
}
