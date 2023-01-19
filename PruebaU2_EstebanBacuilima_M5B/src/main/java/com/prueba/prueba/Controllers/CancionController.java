package com.prueba.prueba.Controllers;

import com.prueba.prueba.Models.Cancion;
import com.prueba.prueba.Models.ListaReproduccion;
import com.prueba.prueba.Services.CancionService;
import com.prueba.prueba.Services.ListaReproduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cancion")
public class CancionController {

    @Autowired
    CancionService cancionService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cancion>> obtenerLista() {
        return new ResponseEntity<>(cancionService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Cancion> crear(@RequestBody Cancion c) {
        return new ResponseEntity<>(cancionService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        cancionService.delete(id);
    }


    @PutMapping("actualizar/{id}")
    public ResponseEntity<Cancion> updateUser(@PathVariable Integer id, @RequestBody Cancion c) {
        if (cancionService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        c.setTitulo(c.getTitulo());
        c.setArtista(c.getArtista());
        c.setAlbum(c.getAlbum());
        c.setYear(c.getYear());

        Cancion newObjeto = cancionService.save(c);
        return ResponseEntity.ok(newObjeto);
    }
}
