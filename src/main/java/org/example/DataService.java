package org.example;

import lombok.Data;
import org.example.model.Opinion;
import org.example.model.Pelicula;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

import static org.example.HibernateUtil.sessionFactory;

@Data
public class DataService implements Serializable {




    public void save(Pelicula pelicula) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(pelicula);
            session.getTransaction().commit();
        }
    }

 public List<Opinion> obtenerOpinion(String email) {
    try (var session = sessionFactory.openSession()) {
        return session.createQuery("FROM Opinion WHERE usuario = :email", Opinion.class)
                      .setParameter("email", email)
                      .getResultList();
    }
}


public void añadirOpinion(Pelicula pelicula, Opinion opinion) {
    try (var session = sessionFactory.openSession()) {
        session.beginTransaction();
        pelicula.añadirOpinion(opinion);
        session.saveOrUpdate(pelicula);
        session.save(opinion);
        session.getTransaction().commit();
    }
}


public void imprimirPeliculasConOpinionesBajas() {
    try (var session = sessionFactory.openSession()) {
        List<Pelicula> peliculas = session.createQuery(
            "SELECT DISTINCT p FROM Pelicula p JOIN p.opinions o WHERE o.puntuacion <= 3", Pelicula.class)
            .getResultList();
        peliculas.forEach(pelicula -> System.out.println(pelicula.getTitulo()));
    }
}
}
