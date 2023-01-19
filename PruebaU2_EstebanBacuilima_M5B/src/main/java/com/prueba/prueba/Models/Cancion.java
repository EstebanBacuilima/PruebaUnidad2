package com.prueba.prueba.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCancion")
    private Integer idCancion;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "artista")
    private String artista;

    @Column(name = "album")
    private String album;

    @Column(name = "year")
    private Number year;

    //References
    @JsonIgnore
    @ManyToMany(mappedBy = "cancion")
    private List<ListaReproduccion> listaReproduccions;

}
