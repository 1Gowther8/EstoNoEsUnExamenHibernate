package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Estrellas")
public class Estrella {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 80)
    private String nombre;

    @Column(name = "magnitud", length = 80)
    private Double magnitud;

    @ManyToOne
    @JoinColumn(name = "constelacion_id")
    private Constelacion constelacion;

    public Estrella() {
    }

    public Estrella(String nombre, Double magnitud) {
        this.nombre = nombre;
        this.magnitud = magnitud;
    }

    public void añadirConstelacion(Constelacion constelacion) {
        constelacion.getEstrellas().add(this);
        this.setConstelacion(constelacion);
    }

    @Override
    public String toString() {
        return "Estrella{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", magnitud=" + magnitud +
                ", constelacion=" + constelacion.getNombreCastellano() +
                '}';
    }
}
