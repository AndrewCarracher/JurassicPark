package com.dino_world.repositories.paddocks;

import com.dino_world.models.Dinosaur;
import com.dino_world.models.Paddock;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public Long checkNewDinosaur(Dinosaur dinosaur){
        List<Paddock> paddockResult = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Paddock.class);
            cr.add(Restrictions.gt("containsCarnivores", dinosaur.isEatsMeat()));
            paddockResult = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        ArrayList<Long> paddocks = new ArrayList<Long>();

        for(int i = 0; i< paddockResult.size(); i++){
                Paddock paddock = paddockResult.get(i);

                if (this.freeSpace(paddock.getName()) > 0) {
                    paddocks.add(paddock.getId());
                }
            }
            if(paddocks.size() > 0) {
                return (paddocks.get(0));
            }

            return null;
        }


    @Transactional
    public void addNewDinosaur(String dinosaurName, int dinosaurAge, String dinosaurSpecies, boolean fed, boolean eatsMeat){
        List<Paddock> paddockResult = null;
        List<Dinosaur> dinosaurResult = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Paddock.class);
            paddockResult = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        for(int i = 0; i< paddockResult.size(); i++){
            if(paddockResult.get(i).isContainsCarnivores() == eatsMeat){
                Paddock paddock = paddockResult.get(i);

                if (this.freeSpace(paddock.getName()) > 0) {
                    Dinosaur dinosaur = new Dinosaur(dinosaurName, dinosaurSpecies, dinosaurAge, fed, eatsMeat);
                    dinosaur.setPaddock(paddock);
                    paddock.addDinosaur(dinosaur);
                }
            }
        }
    }

    @Transactional
    public Dinosaur removeDinosaur(String name, String type, String paddockName){

        List<Paddock> paddockResult = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Paddock.class);
            cr.add(Restrictions.gt("name", paddockName));
            paddockResult = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        if (paddockResult.size() > 0) {
            Paddock paddock = paddockResult.get(0);

            for(int i = 0; i < paddock.numberOfDinosaurs(); i++){
                if (paddock.getOccupants().get(i).getName().equals(name) && paddock.getOccupants().get(i).getType().equals(type)){
                    return paddock.getOccupants().get(i);
                }
            }
        }

        return null;
    }

    @Transactional
    public int freeSpace(String paddockName){

        List<Paddock> paddockResult = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Paddock.class);
            cr.add(Restrictions.gt("name", paddockName));
            paddockResult = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        if (paddockResult.size() > 0) {
            Paddock paddock = paddockResult.get(0);
            return paddock.getCapacity() - paddock.getOccupants().size();

        }

        return 0;
    }
}
