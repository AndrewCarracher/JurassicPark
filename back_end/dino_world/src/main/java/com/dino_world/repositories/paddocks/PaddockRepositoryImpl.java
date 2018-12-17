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
    public boolean checkCompatibility(String dinosaurName, String paddockName){

        List<Paddock> paddockResult = null;
        List<Dinosaur> dinosaurResult = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Paddock.class);
            cr.add(Restrictions.gt("name", paddockName));
            paddockResult = cr.list();
            Criteria newCr = session.createCriteria(Dinosaur.class);
            cr.add(Restrictions.gt("name", dinosaurName));
            dinosaurResult = newCr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        if (paddockResult.size() > 0 && dinosaurResult.size() > 0){
            Dinosaur dinosaur = dinosaurResult.get(0);
            Paddock paddock = paddockResult.get(0);
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

        return false;

    }

    @Transactional
    public void addDinosaur(String dinosaurName, String paddockName){

        List<Paddock> paddockResult = null;
        List<Dinosaur> dinosaurResult = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Paddock.class);
            cr.add(Restrictions.gt("name", paddockName));
            paddockResult = cr.list();
            Criteria newCr = session.createCriteria(Dinosaur.class);
            cr.add(Restrictions.gt("name", dinosaurName));
            dinosaurResult = newCr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        if (paddockResult.size() > 0 && dinosaurResult.size() > 0) {
            Dinosaur dinosaur = dinosaurResult.get(0);
            Paddock paddock = paddockResult.get(0);

            if (checkCompatibility(dinosaur.getName(), paddock.getName())) {
                paddock.addDinosaur(dinosaur);
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
        } finally {
            session.close();
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
        } finally {
            session.close();
        }

        if (paddockResult.size() > 0) {
            Paddock paddock = paddockResult.get(0);
            return paddock.freeSpace();

        }
        
        return 0;
    }
}
