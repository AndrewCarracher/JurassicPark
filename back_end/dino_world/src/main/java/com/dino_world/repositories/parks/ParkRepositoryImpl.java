package com.dino_world.repositories.parks;

import com.dino_world.models.Dinosaur;
import com.dino_world.models.Paddock;
import com.dino_world.models.Park;
import com.dino_world.models.Visitor;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class ParkRepositoryImpl implements ParkRepositoryCustom{

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Park> allParks(){
        List<Park> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Park.class);
            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }


        return result;
    }

    @Transactional
    public void addVisitors(Park park, int time, Visitor visitor){
        if(park.checkParkOpen(time).equals("Park is open")){
            park.addVisitors(visitor);
        }
    }

    @Transactional
    public void removeVisitors(Park park, Visitor visitor){
        park.removeVisitor(visitor);
    }

    @Transactional
    public void removeAllVisitors(Park park){
        park.removeAllVisitors();
    }

    @Transactional
    public void transferDino(Park park, Dinosaur dino, Paddock penFrom, Paddock penTo){
        if(park.checkTransferPen(dino, penTo)){
            park.transferDino(dino.getName(), dino.getType(), dino.isEatsMeat(), penFrom, penTo);
        }

    }
}
