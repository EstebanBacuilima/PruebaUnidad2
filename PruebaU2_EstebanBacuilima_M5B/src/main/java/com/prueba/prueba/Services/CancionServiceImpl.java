package com.prueba.prueba.Services;

import com.prueba.prueba.Models.Cancion;
import com.prueba.prueba.Repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CancionServiceImpl extends GenericServiceImpl<Cancion, Integer> implements CancionService {

    @Autowired
    CancionRepository cancionRepository;

    @Override
    public CrudRepository<Cancion, Integer> getDao() {
        return cancionRepository;
    }

}