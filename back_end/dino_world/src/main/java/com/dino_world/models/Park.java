package com.dino_world.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parks")
public class Park {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnoreProperties("paddocks")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @OneToMany(mappedBy = "park", fetch = FetchType.LAZY)
    private List<Visitor> visitors;

    @JsonIgnoreProperties("visitors")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @OneToMany(mappedBy = "park", fetch = FetchType.LAZY)
    private List<Paddock> pens;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "park_currently_open")
    private boolean parkOpen;

    @Column(name = "park_opens_at")
    private int openAt;

    @Column(name = "park_closes_at")
    private int closedAt;

    @Column(name = "park_in_rampage")
    private boolean rampage;

    public Park(int capacity, boolean parkOpen, int openAt, int closedAt, boolean rampage) {
        this.capacity = capacity;
        this.parkOpen = parkOpen;
        this.openAt = openAt;
        this.closedAt = closedAt;
        this.rampage = rampage;
    }

    public void setPens(ArrayList<Paddock> pens) {
        this.pens = pens;
    }

    public Park() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setVisitors(ArrayList<Visitor> visitors) {
        this.visitors = visitors;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isParkOpen() {
        return parkOpen;
    }

    public void setParkOpen(boolean parkOpen) {
        this.parkOpen = parkOpen;
    }

    public int getOpenAt() {
        return openAt;
    }

    public void setOpenAt(int openAt) {
        this.openAt = openAt;
    }

    public int getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(int closedAt) {
        this.closedAt = closedAt;
    }

    public boolean isRampage() {
        return rampage;
    }

    public void setRampage(boolean rampage) {
        this.rampage = rampage;
    }

    public String checkParkOpen(int time){
        if(getOpenAt() < time && getClosedAt() > time){
            if(!isRampage()){
                return "Park is open";
            }
            return "Park is closed due to rampage";
        }
        return "Outside parks opening hours";
    }

    public Dinosaur findDino(String name, String type, boolean eatsMeat){
            for(int i = 0; i < this.pens.size(); i++){
                if(pens.get(i).isContainsCarnivores() == eatsMeat){

                    for(int n = 0; n < pens.get(i).numberOfDinosaurs(); n++){
                        return pens.get(i).removeDinosaur(name, type);
                    }

                }
            }
            return null;
    }

    public boolean checkTransferPen(Dinosaur dino, Paddock paddock){
            return(paddock.checkCompatibility(dino));
    }

    public void transferDino(String name, String type, boolean eatsMeat, String paddockName){

        if(isRampage()){
            return;
        }

        if(eatsMeat && parkOpen){
            return;
        }


        Dinosaur dino = findDino(name, type, eatsMeat);
        if(dino != null){
            for (int i = 0; i < pens.size(); i++){
                if(pens.get(i).getName().equals(paddockName)){
                    Paddock paddock = pens.get(i);
                    if(checkTransferPen(dino, paddock)){
                        paddock.addDinosaur(dino);
                    }
                }
            }
        }
    }
}
