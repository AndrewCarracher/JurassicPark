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
        } finally {
            session.close();
        }


        return result;
    }
}
