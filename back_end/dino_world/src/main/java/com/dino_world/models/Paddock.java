package com.dino_world.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "paddocks")
public class Paddock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private int capacity;

    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @OneToMany(mappedBy = "paddock", fetch = FetchType.LAZY)
    private List<Dinosaur> occupants;

    @Column(name = "contains_carnivores")
    private boolean containsCarnivores;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "park_id", nullable = false)
    private Park park;

    public Paddock(int capacity, String name, Park park, boolean containsCarnivores) {
        this.name = name;
        this.capacity = capacity;
        this.occupants = new ArrayList<>();
        this.park = park;
        this.containsCarnivores = containsCarnivores;
    }

    public Paddock() {
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isContainsCarnivores() {
        return containsCarnivores;
    }

    public void setContainsCarnivores(boolean containsCarnivores) {
        this.containsCarnivores = containsCarnivores;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setOccupants(ArrayList<Dinosaur> occupants) {
        this.occupants = occupants;
    }

    public int numberOfDinosaurs(){
        return this.occupants.size();
    }

    public List<Dinosaur> getOccupants() {
        return occupants;
    }

    public void addDinosaur(Dinosaur dinosaur){
        if(checkCompatibility(dinosaur)){
            occupants.add(dinosaur);
        }
    }

    public boolean checkCompatibility(Dinosaur dinosaur){
        if(numberOfDinosaurs() == 0){
            return true;
        }
        else if(!dinosaur.isEatsMeat() && !isContainsCarnivores()){
            return true;
        }
        else if (occupants.get(0).getType().equals(dinosaur.getType())){
            return true;
        }
        else{
            return false;
        }
    }

    public Dinosaur removeDinosaur(String name, String type){
        for(int i = 0; i < numberOfDinosaurs(); i++){
            if (occupants.get(i).getName().equals(name) && occupants.get(i).getType().equals(type)){
                return occupants.get(i);
            }
        }
        return null;
    }


}
