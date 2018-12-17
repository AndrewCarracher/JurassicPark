package com.dino_world.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "visitors")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "money")
    private int money;

    @JsonIgnoreProperties("visitors")
    @ManyToOne
    @JoinColumn(name = "park_id", nullable = false)
    private Park park;

    public Visitor(int money) {
        this.money = money;
    }

    public Visitor() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
