package org.example;

import org.example.model.Opinion;
import org.example.model.Pelicula;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        DataService dataService = new DataService();
        Pelicula p4= new Pelicula("Pelicula 4");



        /*Historia 1
        Pelicula p1 = new Pelicula("Segunda Añadida");
        dataService.save(p1);*/

        /*Historia 2
        System.out.println(dataService.obtenerOpinion("user1@example.com"));*/

        /*Historia 3
        Opinion op1=new Opinion("Nueva descripcion añadida","correonuevo@gmail.com",5);
        dataService.añadirOpinion(p4, op1);*/

        /*Historia 4
        dataService.imprimirPeliculasConOpinionesBajas();*/








    }

}