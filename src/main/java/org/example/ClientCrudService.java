package org.example;

import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientCrudService {
    private SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();

    public void creatClient(Client client) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(client);
            tx.commit();
        }
    }
    public Client getClient(int id) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }
    public void updatePlanet(Client client) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.evict(client);
            client.setName(client.getName());
            session.merge(client);
            tx.commit();
        }
    }
    public void deleteClient(int id) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(getClient(id));
            tx.commit();
        }
    }


}
