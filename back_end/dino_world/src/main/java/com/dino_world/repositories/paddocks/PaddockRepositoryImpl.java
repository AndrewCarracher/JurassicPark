package com.dino_world.repositories.paddocks;

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
}
