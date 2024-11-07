package org.example.dao;

import org.example.model.Constelacion;
import org.hibernate.SessionFactory;

public class ConstelacionDAO {

    private SessionFactory sessionFactory;

    public ConstelacionDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void save(Constelacion constelacion) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(constelacion);
            session.getTransaction().commit();
        }
    }

    public void listarPorHemisferio(String hemisferio) {
        try (var session = sessionFactory.openSession()) {
            var query = session.createQuery("select c from Constelacion c where c.hemisferio = :hemisferio", Constelacion.class);
            query.setParameter("hemisferio", hemisferio);
            var resultado = query.list();
            resultado.forEach(System.out::println);
        }
    }

    //Hazme un método que me devuelva todas las constelaciones con hemisferio norte y estrellas con magnitud mayor a 2.0
    public void listarPorHemisferioYEstrellas(String hemisferio) {
        try (var session = sessionFactory.openSession()) {
            var query = session.createQuery("select c from Constelacion c join c.estrellas e where c.hemisferio = :hemisferio and e.magnitud > 2.0", Constelacion.class);
            query.setParameter("hemisferio", hemisferio);
            var resultado = query.list();
            resultado.forEach(System.out::println);
        }
    }


}
