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

import com.mendez.app.jpa.dtos.ServicioDTO;
import com.mendez.app.jpa.dtos.ServicioListDTO;
import com.mendez.app.jpa.services.IService;

@RestController
@RequestMapping("proyecto/servicios")
public class ServiciosController {
	
	//atributos
	
		@Autowired
		IService<ServicioListDTO, ServicioDTO> serviciosService;
		
		
		@PostMapping
		public Map<String, String> guardar(@RequestBody ServicioDTO c){
			serviciosService.guardar(c);
			Map<String, String> respuesta =new HashMap<>();
			respuesta.put("msg", "Servicio guardado correctamente");
			return respuesta;
		}
		
		@GetMapping
		public List<ServicioListDTO> listar() {
			return serviciosService.listar();
		}
		

		@GetMapping("/obtener/{id}")
		public ServicioListDTO obtenerPorId(@PathVariable(name = "id")Long id) {
			Optional<ServicioListDTO> servicio = serviciosService.getById(id);
			if (servicio.isPresent()) {
				return servicio.get();
			}
			else {
				return  null;
			}
		}
		
		@DeleteMapping("/eliminar")
		public Map<String, String> eliminar (@RequestParam(name = "id")Long id){
			serviciosService.eliminar(id);
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("msg", "Servicio eliminado correctamente");
			return respuesta;
		}
		
		@PutMapping("/actualizar/{id}")
		public Map<String, String> actualizar(@RequestBody ServicioDTO c, @PathVariable(name = "id")Long id){
			Optional<ServicioListDTO> servicio = serviciosService.getById(id);
			if (servicio.isPresent()) {
				c.setId(id);
				serviciosService.guardar(c);
			}
			else {
				throw new RuntimeException("El servicio no existe en la bd");
		    }
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("msg", "Servicio actualizado correctamente");
			return respuesta;
		}
		

}
