package org.example.dao;

import org.example.model.Estrella;
import org.hibernate.SessionFactory;

public class EstrellaDAO {
    private SessionFactory sessionFactory;

    public EstrellaDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void delete(Estrella estrella) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(estrella);
            session.getTransaction().commit();
        }
    }

    public Estrella findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            Estrella estrella = session.get(Estrella.class, id);
            session.getTransaction().commit();
            return estrella;
        }
    }

    public void save(Estrella estrella) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(estrella);
            session.getTransaction().commit();
        }
    }

    public void actualizarMagnitud(Long id, double magnitud) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            Estrella estrella = session.get(Estrella.class, id);
            estrella.setMagnitud(magnitud);
            session.getTransaction().commit();
        }
    }

}
