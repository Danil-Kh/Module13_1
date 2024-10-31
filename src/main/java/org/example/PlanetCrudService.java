package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlanetCrudService {
    private SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();

    public Planet getPlanetName(String id) {
            try(Session session = sessionFactory.openSession()) {
             return session.get(Planet.class, id);
            }
    }
    public void createPlanet(Planet planet) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(planet);
            tx.commit();
        }
    }
    public void updatePlanet(Planet planet) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.evict(planet);
            planet.setName(planet.getName());
            session.merge(planet);
            tx.commit();
        }
    }
    public void deletePlanet(String id) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            session.remove(planet);
            tx.commit();
        }
    }


}
