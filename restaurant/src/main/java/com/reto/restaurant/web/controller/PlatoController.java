package com.reto.restaurant.web.controller;

import com.reto.restaurant.domain.service.PlatoService;
import com.reto.restaurant.persistence.entity.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant/plato")
@CrossOrigin("*")
public class PlatoController {

    private final PlatoService platoService;

    @Autowired
    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping
    public List<Plato> getAllPlatos() {
        return platoService.getAll();
    }

    @GetMapping("/{id}")
    public Plato getPlatobyId(@PathVariable Long id) {

        return platoService.getById(id);
    }

    @PostMapping
    public Plato savePlato(@RequestBody Plato plato) {

        return platoService.savePlato(plato);
    }

    @PutMapping("/{id}")
    public Plato updatePlato(@PathVariable Long id, @RequestBody Plato plato) throws ChangeSetPersister.NotFoundException {
        // Asegúrate de que el plato exista antes de intentar actualizarlo
        Plato existingPlato = platoService.getById(id);
        if (existingPlato == null) {
            // Manejar el caso en que el plato no exista
            // Puedes lanzar una excepción, devolver un código de error, etc.
            // Por ejemplo, lanzar una NotFoundException:
            throw new ChangeSetPersister.NotFoundException();
        }

        // Actualiza los campos relevantes del plato existente
        existingPlato.setNombre(plato.getNombre());
        existingPlato.setDescripcion(plato.getDescripcion());
        existingPlato.setPrecio(plato.getPrecio());

        // Guarda y devuelve el plato actualizado
        return platoService.savePlato(existingPlato);
    }

    @DeleteMapping("/{id}")
    public void deletePlato(@PathVariable Long id) {

        platoService.deletePlato(id);
    }


}
