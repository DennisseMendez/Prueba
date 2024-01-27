package com.mendez.app.jpa.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mendez.app.jpa.models.Reservacion;
import com.mendez.app.jpa.services.IService;

@RestController
@RequestMapping("proyecto/reservaciones")
public class ReservacionesController {
	
	//atributos
	
		@Autowired
		IService<Reservacion, Reservacion> reservacionesService;
		
		
		@PostMapping
		public Map<String, String> guardar(@RequestBody Reservacion c){
			reservacionesService.guardar(c);
			Map<String, String> respuesta =new HashMap<>();
			respuesta.put("msg", "Reservacion guardado correctamente");
			return respuesta;
		}
		
		@GetMapping
		public List<Reservacion> listar() {
			return this.reservacionesService.listar();
		}
		

		@GetMapping("/obtener/{id}")
		public Reservacion obtenerPorId(@PathVariable(name = "id")Long id) {
			Optional<Reservacion> reservacion = reservacionesService.getById(id);
			if (reservacion.isPresent()) {
				return reservacion.get();
			}
			else {
				return  null;
			}
		}
		
		@DeleteMapping("/eliminar")
		public Map<String, String> eliminar (@RequestParam(name = "id")Long id){
			reservacionesService.eliminar(id);
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("msg", "Reservacion eliminado correctamente");
			return respuesta;
		}
		
		@PutMapping("/actualizar/{id}")
		public Map<String, String> actualizar(@RequestBody Reservacion c, @PathVariable(name = "id")Long id){
			Optional<Reservacion> reservacion = reservacionesService.getById(id);
			if (reservacion.isPresent()) {
				c.setId(id);
				reservacionesService.guardar(c);
			}
			else {
				throw new RuntimeException("La reservación no existe en la bd");
		    }
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("msg", "Reservacion actualizado correctamente");
			return respuesta;
		}
		

}
