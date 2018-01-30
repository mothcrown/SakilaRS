/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.sakilars.data.actor;

import es.cifpcm.sakilars.data.NewHibernateUtil;
import es.cifpcm.sakilars.model.Actor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author mothcrown
 */
public class ActorDaoImpl implements ActorDao {

    /**
     * Nice and easy!
     * @return 
     */
    @Override
    public List<Actor> selectAll() {
        List<Actor> actors = new ArrayList<>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            actors.addAll(session.createCriteria(Actor.class).list());
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        
        return actors;
    }
    /**
     * Esto fue más complicado de lo que debería. Creo que me he complicado
     * la vida cosa chunga. Meh!
     * @param actorId
     * @return 
     */
    @Override
    public Actor searchByCriteria(int actorId) {
        Actor actor = new Actor();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            
            Criteria criteria = session.createCriteria(Actor.class)
                    .add(Restrictions.eq("actorId", (short) actorId));
            actor = (Actor) criteria.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        
        return actor;
    }

    /**
     * Inserta actor y actualiza actor. Qué majo!
     * @param actor
     * @return 
     */
    @Override
    public Actor insert(Actor actor) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(actor);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        
        return actor;
    }
    
}
