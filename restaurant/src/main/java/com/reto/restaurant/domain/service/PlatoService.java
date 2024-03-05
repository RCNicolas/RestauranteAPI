package com.reto.restaurant.domain.service;

import com.reto.restaurant.domain.repository.PlatoRepository;
import com.reto.restaurant.persistence.entity.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;


    public List<Plato> getAll() {

        return platoRepository.findAll();
    }

    public Plato getById(Long id ){

        return platoRepository.findById(id).orElse(null);
    }

    public Plato savePlato(Plato plato) {

        return platoRepository.save(plato);
    }

    public void deletePlato(Long id) {

        platoRepository.deleteById(id);
    }

    public void updatePlato(Long id, Plato plato){
        Plato platoUno = platoRepository.findById(id).orElse(null);

        platoUno.setNombre(plato.getNombre());
        platoUno.setDescripcion(plato.getDescripcion());
        platoUno.setPrecio(plato.getPrecio());

        platoRepository.save(platoUno);
    }

}
