package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Constelaciones")
public class Constelacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre_castellano")
    private String nombreCastellano;

    @Column(name = "nombre_latin")
    private String nombreLatin;

    @Column(name = "hemisferio")
    private String hemisferio;

    @OneToMany(mappedBy = "constelacion", fetch=FetchType.EAGER)
    private List<Estrella> estrellas = new ArrayList<>();

    public Constelacion() {
    }

    public Constelacion(String nombreCastellano, String nombreLatin, String hemisferio) {
        this.nombreCastellano = nombreCastellano;
        this.nombreLatin = nombreLatin;
        this.hemisferio = hemisferio;
    }

    public void añadirEstrella(Estrella estrella) {
        estrella.setConstelacion(this);
        this.estrellas.add(estrella);
    }

}
