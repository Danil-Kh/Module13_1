package org.example;


import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static final HibernateUtil INSTANCE;

    private final SessionFactory sessionFactory;

    HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    static {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/spacetraveldb", "Danil", "astra121")
                .locations("db/migration")
                .load();
        flyway.migrate();
        INSTANCE = new HibernateUtil();
    }



    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}