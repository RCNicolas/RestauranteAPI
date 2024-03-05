package com.reto.restaurant.web.controller;

import com.reto.restaurant.domain.service.PlatoService;
import com.reto.restaurant.persistence.entity.Plato;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("/{id}")
    public void deletePlato(@PathVariable Long id) {

        platoService.deletePlato(id);
    }


}
