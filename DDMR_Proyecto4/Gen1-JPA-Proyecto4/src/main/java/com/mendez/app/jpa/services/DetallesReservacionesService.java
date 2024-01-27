package com.mendez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendez.app.jpa.dao.IDetalleReservacionDao;
import com.mendez.app.jpa.models.DetalleReservacion;

@Service
public class DetallesReservacionesService implements IService<DetalleReservacion, DetalleReservacion>{
	
	//atributos
	
		@Autowired
		private IDetalleReservacionDao detalleReservacionDao;
		
		
		
		
		//metodos

		@Override
		public List<DetalleReservacion> listar() {
			List<DetalleReservacion> detalleReservaciones = new ArrayList<DetalleReservacion>();
			detalleReservaciones = (List<DetalleReservacion>)detalleReservacionDao.findAll();
			return detalleReservaciones;
		}

		@Override
		public Optional<DetalleReservacion> getById(Long id) {
			// TODO Auto-generated method stub
			Optional<DetalleReservacion> detalleReservacion = detalleReservacionDao.findById(id);
			return detalleReservacion;
		}

		@Override
		public void guardar(DetalleReservacion t) {
			// TODO Auto-generated method stub
			this.detalleReservacionDao.save(t);
			
		}

		@Override
		public void eliminar(Long id) {
			// TODO Auto-generated method stub
			this.detalleReservacionDao.deleteById(id);
			
		}
		

}
