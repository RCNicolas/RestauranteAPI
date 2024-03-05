package com.reto.restaurant;

import com.reto.restaurant.domain.service.PlatoService;
import com.reto.restaurant.persistence.entity.Plato;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(RestaurantApplication.class, args);
		PlatoService platoService = context.getBean(PlatoService.class);

//		Plato Guardar
//		Plato plato = new Plato();
//		plato.setNombre("Arroz con pollo");
//		plato.setDescripcion("Plato creado por los dioses");
//		plato.setPrecio(10000);
////
//		platoService.savePlato(plato);

//		Plato Traer todos
//		List<Plato> platos = platoService.getAll();
//		System.out.println(platos);
//		System.out.println("----------------------------------------------------------");
////		Plato traer por id
//		Plato platoId = platoService.getById(1L);
//		System.out.println(platoId);

//		Plato Eliminar
//		platoService.deletePlato(1L);

//		Plato Actualizar
//		Plato platoUpd = new Plato();
//		platoUpd.setPrecio(20000);
//		platoUpd.setDescripcion("Plato de pasta actualizado");
//		platoUpd.setNombre("Pasta");
//		platoService.updatePlato(2L, platoUpd);


	}

}
