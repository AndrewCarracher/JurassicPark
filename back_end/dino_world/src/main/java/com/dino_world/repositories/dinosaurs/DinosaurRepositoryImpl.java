package com.dino_world.repositories.dinosaurs;

import com.dino_world.models.Dinosaur;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class DinosaurRepositoryImpl implements DinosaurRepositoryCustom {

    @Autowired
    EntityManager entityManager;


    @Transactional
    public List<Dinosaur> allDinosaurs(){
        List<Dinosaur> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Dinosaur.class);
            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }


        return result;
    }

    @Transactional
    public List<Dinosaur> getDinosaurByName(String name){
        List<Dinosaur> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Dinosaur.class);
            cr.add(Restrictions.gt("name", name));
            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }


        return result;
    }

    @Transactional
    public void feedDinosaur(String name){
        List<Dinosaur> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Dinosaur.class);
            cr.add(Restrictions.gt("name", name));
            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        if (result.size() > 0){
            Dinosaur dinosaur = result.get(0);
            dinosaur.setFed(true);
        }

    }


}
