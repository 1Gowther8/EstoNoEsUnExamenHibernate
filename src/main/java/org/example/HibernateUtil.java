package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory sessionFactory;

    static{
        sessionFactory = new Configuration()
                .configure()
                .setProperty("hibernate.connection.password",System.getenv("MYSQL_ROOT_PASSWORD"))
                .setProperty("hibernate.connection.username",System.getenv("MYSQL_USER"))
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
