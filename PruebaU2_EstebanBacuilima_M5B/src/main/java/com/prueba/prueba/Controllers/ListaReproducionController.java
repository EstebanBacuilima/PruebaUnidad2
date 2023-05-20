package com.prueba.prueba.Controllers;

import com.prueba.prueba.Models.Cancion;
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

    @PutMapping("/listcancion/update/{id}")
    public ResponseEntity<ListaReproduccion> updateClientOTHER(@RequestBody ListaReproduccion listaReproduccion, @PathVariable("id") Integer id){
        ListaReproduccion listarUp = listaReproducionService.findById(id);
        if(listarUp == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                List<Cancion> currentSongs = listarUp.getCancion();
                currentSongs.addAll(listaReproduccion.getCancion());
                listarUp.setCancion(currentSongs);
                return new ResponseEntity<>(listaReproducionService.save(listarUp), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
