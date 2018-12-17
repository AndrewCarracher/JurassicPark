package com.dino_world.repositories.paddocks;

import com.dino_world.models.Dinosaur;
import com.dino_world.models.Paddock;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class PaddockRepositoryImpl implements  PaddockRepositoryCustom{

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Paddock> allPaddocks(){
        List<Paddock> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Paddock.class);
            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }


        return result;
    }

    @Transactional
    public boolean checkCompatibility(Dinosaur dinosaur, Paddock paddock){
        if(paddock.numberOfDinosaurs() == 0){
            return true;
        }
        else if(!dinosaur.isEatsMeat() && !paddock.isContainsCarnivores()){
            return true;
        }
        else if (paddock.getOccupants().get(0).getType().equals(dinosaur.getType())){
            return true;
        }
        else{
            return false;
        }
    }

    @Transactional
    public void addDinosaur(Dinosaur dinosaur, Paddock paddock){
        if(checkCompatibility(dinosaur, paddock)){
            paddock.addDinosaur(dinosaur);
        }
    }

    @Transactional
    public Dinosaur removeDinosaur(String name, String type, Paddock paddock){
        for(int i = 0; i < paddock.numberOfDinosaurs(); i++){
            if (paddock.getOccupants().get(i).getName().equals(name) && paddock.getOccupants().get(i).getType().equals(type)){
                return paddock.getOccupants().get(i);
            }
        }
        return null;
    }

    @Transactional
    public int freeSpace(Paddock paddock){
        return paddock.freeSpace();
    }
}
