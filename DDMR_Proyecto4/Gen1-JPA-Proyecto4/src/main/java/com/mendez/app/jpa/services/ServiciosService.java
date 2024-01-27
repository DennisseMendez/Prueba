package com.mendez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendez.app.jpa.dao.IDetalleReservacionDao;
import com.mendez.app.jpa.dao.IServicioDao;
import com.mendez.app.jpa.dtos.ServicioDTO;
import com.mendez.app.jpa.dtos.ServicioListDTO;
import com.mendez.app.jpa.models.Servicio;
@Service
public class ServiciosService implements IService<ServicioListDTO, ServicioDTO> {
	
	//atributos
	
		@Autowired
		private IServicioDao serviciosDao;
		
		
		private IDetalleReservacionDao detalles_reservacionDao;
		
		
		
		//metodos

		@Override
		public List<ServicioListDTO> listar() {
			List<Servicio> servicios = new ArrayList<>();
			servicios = (List<Servicio>) serviciosDao.findAll();
			
			return servicios.stream().map((s)->{
				return this.convertirServicioaDTO(s);
			}).toList();
				
			}
		

		@Override
		public Optional<ServicioListDTO> getById(Long id) {
			// TODO Auto-generated method stub
			Optional<Servicio> servicio = serviciosDao.findById(id);
			return Optional.of(this.convertirServicioaDTO(servicio.get()));
		}

		@Override
		public void guardar(ServicioDTO t) {
			this.serviciosDao.save(convertirDTOaServicio(t));
			
		}

		@Override
		public void eliminar(Long id) {
			// TODO Auto-generated method stub
			this.serviciosDao.deleteById(id);
			
		}
		
		//metodo para convertir DTO en un modelo original
		public Servicio  convertirDTOaServicio (ServicioDTO serviciodto) {
			Servicio s = new Servicio();
			s.setId(serviciodto.getId());
			s.setNombre(serviciodto.getNombre());
			s.setDescripcion(serviciodto.getDescripcion());
			s.setCantidad(serviciodto.getCantidad());
			s.setPrecio(serviciodto.getPrecio());
			s.setDetalle_reservacion(detalles_reservacionDao.findById(serviciodto.getDetalle_reservacion()).get());
			return s;
		}
		
		public ServicioListDTO convertirServicioaDTO (Servicio s) {
			ServicioListDTO serviciodto = new ServicioListDTO();
			serviciodto.setId(s.getId());
			serviciodto.setNombre(s.getNombre());
			serviciodto.setDescripcion(s.getDescripcion());
			serviciodto.setCantidad(s.getCantidad());
			serviciodto.setPrecio(s.getPrecio());
			serviciodto.setDetalle_reservacion(s.getDetalle_reservacion());
			return serviciodto;
		}
		
		
		

}
