package com.dino_world.repositories.parks;

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
    public void addVisitors(int time, int visitorId){

        List<Park> parkResult = null;
        List<Visitor> visitorResult = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Park.class);
            parkResult = cr.list();
            Criteria visitCr = session.createCriteria(Visitor.class);
            cr.add(Restrictions.gt("id", visitorId));
            visitorResult = visitCr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        if(parkResult != null){
            Park park = parkResult.get(0);
            Visitor visitor = visitorResult.get(0);
            if(park.checkParkOpen(time).equals("Park is open")){
                park.addVisitors(visitor);
            }
        }






    }

    @Transactional
    public void removeVisitors(int visitorId){




        park.removeVisitor(visitor);
    }

    @Transactional
    public void removeAllVisitors(){




        park.removeAllVisitors();
    }

    @Transactional
    public void transferDino(String dinoName, String penFromName, String penToName){
        if(park.checkTransferPen(dino, penTo)){
            park.transferDino(dino.getName(), dino.getType(), dino.isEatsMeat(), penFrom, penTo);
        }

    }
}
