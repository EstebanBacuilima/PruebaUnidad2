package com.prueba.prueba.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class ListaReproduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idListaReproduccion")
    private Integer idListaReproduccion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="idCancion",referencedColumnName ="idCancion")
    private Cancion cancion;

}
