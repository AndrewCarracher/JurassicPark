package com.dino_world.repositories.parks;

import com.dino_world.models.Park;
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
        }


        return result;
    }

    @Transactional
    public void changeRampage(){
        List<Park> parkResult = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Park.class);
            parkResult = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        if(parkResult != null){
            Park park = parkResult.get(0);
            if(park.isRampage()){
                park.setRampage(false);
            }else{
                park.setRampage(true);
            }
        }
    }

    @Transactional
    public void changeParkOpen(){
        List<Park> parkResult = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Park.class);
            parkResult = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        if(parkResult != null){
            Park park = parkResult.get(0);
           if (!park.isParkOpen()){
               park.setParkOpen(true);
           }else{
               park.setParkOpen(false);
           }
        }
    }

    @Transactional
    public void addVisitor(){
        List<Park> parkResult = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Park.class);
            parkResult = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        if(parkResult != null){
            Park park = parkResult.get(0);
                park.addVisitor();
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
        }

        if(parkResult != null){
            Park park = parkResult.get(0);
            park.removeAllVisitors();
        }
    }

}
