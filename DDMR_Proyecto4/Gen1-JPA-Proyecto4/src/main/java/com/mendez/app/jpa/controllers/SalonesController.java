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

import com.mendez.app.jpa.models.Salon;
import com.mendez.app.jpa.services.IService;

@RestController
@RequestMapping("proyecto/salones")
public class SalonesController {
	
	//atributos
	
	@Autowired
	IService<Salon, Salon> salonService;
	
	
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody Salon  c){
		salonService.guardar(c);
		Map<String, String> respuesta =new HashMap<>();
		respuesta.put("msg", "Salon guardado correctamente");
		return respuesta;
	}
	
	@GetMapping
	public List<Salon> listar() {
		return this.salonService.listar();
	}
	

	@GetMapping("/obtener/{id}")
	public Salon obtenerPorId(@PathVariable(name = "id")Long id) {
		Optional<Salon> salon = salonService.getById(id);
		if (salon.isPresent()) {
			return salon.get();
		}
		else {
			return  null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar (@RequestParam(name = "id")Long id){
		salonService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Salon eliminado correctamente");
		return respuesta;
		
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody Salon c, @PathVariable(name = "id")Long id){
		Optional<Salon> salon = salonService.getById(id);
		if (salon.isPresent()) {
			c.setId(id);
			salonService.guardar(c);
		}
		else {
			throw new RuntimeException("El salon no existe en la bd");
	    }
		
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Salon actualizado correctamente");
		return respuesta;
	}

}
