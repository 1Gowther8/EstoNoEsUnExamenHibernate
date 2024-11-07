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



//Historia de usuario 1
    public void save(Pelicula pelicula) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(pelicula);
            session.getTransaction().commit();
        }
    }
    //Historia de usuario 2
 public List<Opinion> obtenerOpinion(String email) {
    try (var session = sessionFactory.openSession()) {
        return session.createQuery("FROM Opinion WHERE usuario = :email", Opinion.class)
                      .setParameter("email", email)
                      .getResultList();
    }
}

//historia de usuario 3
public void añadirOpinion(Pelicula pelicula, Opinion opinion) {
    try (var session = sessionFactory.openSession()) {
        session.beginTransaction();
        pelicula.añadirOpinion(opinion);
        session.persist(pelicula);
        session.persist(opinion);
        session.getTransaction().commit();
    }
}

//historia de usuario 4
public void imprimirPeliculasConOpinionesBajas() {
    try (var session = sessionFactory.openSession()) {
        List<Pelicula> peliculas = session.createQuery(
            "SELECT DISTINCT p FROM Pelicula p JOIN p.opinions o WHERE o.puntuacion <= 3", Pelicula.class)
            .getResultList();
        peliculas.forEach(pelicula -> System.out.println(pelicula.getTitulo()));
    }
}
}
