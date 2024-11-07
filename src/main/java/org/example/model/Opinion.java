package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
//Esta clase representa una entidad de la base de datos que almacena información sobre una opinión.
@Data
@Entity
@Table(name = "opinion")
public class Opinion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "descripcion", length = 80)
    private String descripcion;

    @Column(name = "usuario", length = 80)
    private String usuario;

    @Column(name = "puntuacion")
    private Integer puntuacion;




    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    public Opinion() {
    }

    public Opinion(String descripcion, String usuario, Integer puntuacion) {
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.puntuacion = puntuacion;

    }

    public void añadirPelicula(Pelicula pelicula) {
        pelicula.getOpinions().add(this);
        this.setPelicula(pelicula);
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", usuario='" + usuario + '\'' +
                ", puntuacion=" + puntuacion +
                ", pelicula=" + pelicula.getTitulo() +
                '}';
    }
}
