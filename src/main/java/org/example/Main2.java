package org.example;

import org.example.HibernateUtil;
import org.example.dao.ConstelacionDAO;
import org.example.dao.EstrellaDAO;

import static org.example.HibernateUtil.getSessionFactory;

public class Main2 {
    public static void main(String[] args) {

        EstrellaDAO estrellaDAO = new EstrellaDAO(getSessionFactory());
        ConstelacionDAO constelacionDAO = new ConstelacionDAO(getSessionFactory());


       // estrellaDAO.actualizarMagnitud(1L, 10.0);
        //constelacionDAO.listarPorHemisferio("Norte");
        constelacionDAO.listarPorHemisferioYEstrellas("Norte");



    }
}
