package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pelicula")
public class Pelicula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "titulo")
    private String titulo;



    @OneToMany(mappedBy = "pelicula", fetch=FetchType.EAGER)
    private List<Opinion> opinions = new ArrayList<>();

    public Pelicula() {
    }

    public Pelicula(String titulo) {
        this.titulo = titulo;
    }

    public void añadirOpinion(Opinion opinion) {
        opinion.setPelicula(this);
        this.opinions.add(opinion);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", opinions=" + opinions +
                '}';
    }
}
