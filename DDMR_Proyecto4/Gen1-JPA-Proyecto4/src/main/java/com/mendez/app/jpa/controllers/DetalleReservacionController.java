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

import com.mendez.app.jpa.models.DetalleReservacion;
import com.mendez.app.jpa.services.IService;

@RestController
@RequestMapping("proyecto/detalleReservacion")
public class DetalleReservacionController {
	
	@Autowired
	IService<DetalleReservacion, DetalleReservacion> detalleReservacionService;
	
	
	
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody DetalleReservacion c){
		detalleReservacionService.guardar(c);
		Map<String, String> respuesta =new HashMap<>();
		respuesta.put("msg", "El detalle de reservacion se guardo correctamente");
		return respuesta;
	}
	
	@GetMapping
	public List<DetalleReservacion> listar(){
		return detalleReservacionService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public DetalleReservacion obtenerPorId(@PathVariable(name = "id")Long id) {
		Optional<DetalleReservacion> detalleReservacion = detalleReservacionService
				.getById(id);
		if(detalleReservacion.isPresent()) {
			return detalleReservacion.get();
		}
		else {
			return null;
		}
	}

	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "id")Long id){
		detalleReservacionService.eliminar(id);
		Map<String, String> respuesta=new HashMap<>();
		respuesta.put("msg", "Detalle de reservacion eliminado correctamente");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody DetalleReservacion c, @PathVariable(name="id")Long id){
		Optional<DetalleReservacion> detalleReservacion= detalleReservacionService.getById(id);
		if(detalleReservacion.isPresent()) {
			c.setId(id);
			detalleReservacionService.guardar(c);
		}
		else {
			throw new RuntimeException("El detalle de reservacion no existe en la bd");
		}
		Map<String, String> respuesta=new HashMap<>();
		respuesta.put("msg", "El detalle de reservacion se ha actualizado correctamente");
		return respuesta;
	}
	
	

}
