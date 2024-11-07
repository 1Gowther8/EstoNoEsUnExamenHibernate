package org.example;

import org.example.dao.ConstelacionDAO;
import org.example.dao.EstrellaDAO;
import org.example.model.Constelacion;
import org.example.model.Estrella;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

import static org.example.HibernateUtil.getSessionFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ConstelacionDAO constelacionDAO = new ConstelacionDAO(getSessionFactory());
        EstrellaDAO estrellaDAO = new EstrellaDAO(getSessionFactory());

        Constelacion c = new Constelacion("Constelacion1", "CasiopeaLatin", "Sur");
        Estrella e = new Estrella("Estrella1", 1.6);
        Estrella e2 = new Estrella("Estrella2", 2.6);

        c.añadirEstrella(e);
        c.añadirEstrella(e2);

        constelacionDAO.save(c);
        estrellaDAO.save(e);
        estrellaDAO.save(e2);

        System.out.println("Estrella 1 " + e);
        c.getEstrellas().forEach(System.out::println); // Enseña todas las estrellas de una constelacion que es cConstelacionDAO constelacionDAO = new ConstelacionDAO(getSessionFactory());





          /*  Constelacion c = new Constelacion("Constelacion1", "CasiopeaLatin", "Sur");

            Estrella e = new Estrella("Estrella1", 1.6);

            Estrella e2 = new Estrella("Estrella2", 2.6);

            c.añadirEstrella(e);
            c.añadirEstrella(e2);

            session.persist(c);
            session.persist(e);
            session.persist(e2);

            session.getTransaction().commit();

            System.out.println("Estrella 1 " + e);
            c.getEstrellas().forEach(System.out::println); // Enseña todas las estrellas de una constelacion que es c


        });


        //Borrar una estrella//

           EstrellaDAO estrellaDAO = new EstrellaDAO(getSessionFactory());
            Estrella estrellaborar=estrellaDAO.findById(29L);
        estrellaDAO.delete(estrellaborar);
         estrellaborar=estrellaDAO.findById(30L);
        estrellaDAO.delete(estrellaborar);*/


    }

}