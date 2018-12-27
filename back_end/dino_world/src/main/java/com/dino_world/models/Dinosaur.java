package com.dino_world.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name ="dinosaurs")
public class Dinosaur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "species")
    private String species;

    @Column(name = "age")
    private int age;

    @Column(name = "fed")
    private boolean fed;

    @Column(name = "eats_meat")
    private boolean eatsMeat;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "paddock_id", nullable = false)
    private Paddock paddock;

    public Dinosaur(String name, String species, int age, boolean fed, boolean eatsMeat){
        this.name = name;
        this.species = species;
        this.age = age;
        this.fed = fed;
        this.eatsMeat = eatsMeat;
    }

    public Dinosaur() {
    }

    public Paddock getPaddock() {
        return paddock;
    }

    public void setPaddock(Paddock paddock) {
        this.paddock = paddock;
    }

    public boolean isEatsMeat() {
        return eatsMeat;
    }

    public void setEatsMeat(boolean eatsMeat) {
        this.eatsMeat = eatsMeat;
    }

    public boolean isFed() {
        return fed;
    }

    public void setFed(boolean fed) {
        this.fed = fed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
