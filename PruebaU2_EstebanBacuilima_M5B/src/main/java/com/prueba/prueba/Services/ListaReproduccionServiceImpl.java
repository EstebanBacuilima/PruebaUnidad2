package com.prueba.prueba.Services;

import com.prueba.prueba.Models.Cancion;
import com.prueba.prueba.Models.ListaReproduccion;
import com.prueba.prueba.Repository.ListaReproduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ListaReproduccionServiceImpl extends GenericServiceImpl<ListaReproduccion, Integer> implements ListaReproduccionService {

    @Autowired
    ListaReproduccionRepository listaReproduccionRepository;

    @Override
    public CrudRepository<ListaReproduccion, Integer> getDao() {
        return listaReproduccionRepository;
    }

}