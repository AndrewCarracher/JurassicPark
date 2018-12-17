package com.dino_world.repositories.parks;

import com.dino_world.models.Dinosaur;
import com.dino_world.models.Paddock;
import com.dino_world.models.Park;
import com.dino_world.models.Visitor;

import java.util.List;

public interface ParkRepositoryCustom {
    List<Park> allParks();
    void addVisitors(Park park, int time, Visitor visitor);
    void removeVisitors(Park park, Visitor visitor);
    void removeAllVisitors(Park park);
    void transferDino(Park park, Dinosaur dino, Paddock penFrom, Paddock penTo);
}
