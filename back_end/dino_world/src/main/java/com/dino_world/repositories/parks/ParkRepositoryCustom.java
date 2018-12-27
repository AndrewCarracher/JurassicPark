package com.dino_world.repositories.parks;

import com.dino_world.models.Park;

import java.util.List;

public interface ParkRepositoryCustom {
    List<Park> allParks();
    void addVisitor();
    void removeAllVisitors();
    void changeParkOpen();
    void changeRampage();
}
