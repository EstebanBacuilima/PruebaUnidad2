package com.prueba.prueba.Controllers;

import com.prueba.prueba.Models.ListaReproduccion;
import com.prueba.prueba.Services.ListaReproduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/listaReproduccion")
public class ListaReproducionController {

    @Autowired
    ListaReproduccionService listaReproducionService;

    @GetMapping("/listar")
    public ResponseEntity<List<ListaReproduccion>> obtenerLista() {
        return new ResponseEntity<>(listaReproducionService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ListaReproduccion> crear(@RequestBody ListaReproduccion c) {
        return new ResponseEntity<>(listaReproducionService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        listaReproducionService.delete(id);
    }


    @PutMapping("actualizar/{id}")
    public ResponseEntity<ListaReproduccion> updateUser(@PathVariable Integer id, @RequestBody ListaReproduccion c) {
        if (listaReproducionService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        c.setNombre(c.getNombre());
        c.setDescripcion(c.getDescripcion());
        c.setCancion(c.getCancion());

        ListaReproduccion newObjeto = listaReproducionService.save(c);
        return ResponseEntity.ok(newObjeto);
    }
}
