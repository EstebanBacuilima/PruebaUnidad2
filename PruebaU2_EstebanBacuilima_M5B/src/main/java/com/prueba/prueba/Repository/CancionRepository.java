package com.prueba.prueba.Repository;

import com.prueba.prueba.Models.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository<Cancion, Integer> {
}
