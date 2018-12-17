package com.dino_world.repositories.parks;

import com.dino_world.models.Park;

import java.util.List;

public interface ParkRepositoryCustom {
    List<Park> allParks();
    void addVisitors(int time, int visitorId);
    void removeVisitors(int visitorId);
    void removeAllVisitors();
    void transferDino(String dinoName, String penFromName, String penToName);
}
