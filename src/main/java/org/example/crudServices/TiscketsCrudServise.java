package org.example.crudServices;

import org.example.Exceptions.ClientNullExceptions;
import org.example.HibernateUtil;
import org.example.Exceptions.PlanetNullExceptions;
import org.example.entity.Client;
import org.example.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class TiscketsCrudServise {
    private SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();

    public Ticket readTicket(int id) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }
    public void updateTicket(Ticket ticket) {
        if (ticket.getFromPlanet() == null || ticket.getToPlanetId() == null) {
            throw new PlanetNullExceptions("planet is null");
        }
        if (ticket.getClient() == null) {
            throw new ClientNullExceptions("client is null");
        }
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.evict(ticket);
            ticket.setCreatedAt(ticket.getCreatedAt());
            ticket.setClient(ticket.getClient());

            ticket.setFromPlanet(ticket.getFromPlanet());
            ticket.setToPlanetId(ticket.getToPlanetId());
            session.merge(ticket);
            session.getTransaction().commit();
        }
    }
    public void deleteTicket(int id) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(readTicket(id));
            session.getTransaction().commit();
        }
    }
    public void createTicket(Ticket ticket) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            if (ticket.getFromPlanet() == null || ticket.getToPlanetId() == null) {
                throw new PlanetNullExceptions("planet is null");
            }
            session.persist(ticket);
            session.getTransaction().commit();
        } catch (PlanetNullExceptions e) {
            throw new PlanetNullExceptions("\"planet is null\"");
        }
    }
}
