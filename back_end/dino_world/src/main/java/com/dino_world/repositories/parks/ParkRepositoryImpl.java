package com.dino_world.repositories.parks;

import com.dino_world.models.Dinosaur;
import com.dino_world.models.Paddock;
import com.dino_world.models.Park;
import com.dino_world.models.Visitor;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
    public int visitorCount(){
        List<Park> parkResult = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Park.class);
            parkResult = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }


        Park park = parkResult.get(0);
        return park.checkNumberOfVisitors();

    }

    @Transactional
    public void addVisitors(int time){

        List<Park> parkResult = null;
        Visitor visitor = new Visitor();
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Park.class);
            parkResult = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        if(parkResult != null){
            Park park = parkResult.get(0);
            if(park.checkParkOpen(time).equals("Park is open")){
                park.addVisitors(visitor);
            }
        }

    }


    @Transactional
    public void removeAllVisitors(){

        List<Park> parkResult = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Park.class);
            parkResult = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        if(parkResult != null){
            Park park = parkResult.get(0);
            park.removeAllVisitors();
        }
    }

    @Transactional
    public void transferDino(String dinoName, String penFromName, String penToName){

        List<Park> parkResult = null;
        List<Dinosaur> dinoResult = null;
        List<Paddock> penFrom = null;
        List<Paddock> penTo = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Park.class);
            parkResult = cr.list();
            Criteria dinoCr = session.createCriteria(Dinosaur.class);
            dinoCr.add(Restrictions.gt("name", dinoName));
            dinoResult = dinoCr.list();
            Criteria penFromCr = session.createCriteria(Paddock.class);
            penFromCr.add(Restrictions.gt("name", penFromName));
            penFrom = penFromCr.list();
            Criteria penToCr = session.createCriteria(Paddock.class);
            penToCr.add(Restrictions.gt("name", penToName));
            penFrom = penToCr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        if(parkResult != null){
            Park park = parkResult.get(0);
            Paddock penFromResult = penFrom.get(0);
            Paddock penToResult = penTo.get(0);
            Dinosaur dino = dinoResult.get(0);

            if(park.checkTransferPen(dino, penToResult)){
                park.transferDino(dino.getName(), dino.getType(), dino.isEatsMeat(), penFromResult, penToResult);
            }
        }

    }
}
