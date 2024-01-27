package com.mendez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendez.app.jpa.dao.IReservacionDao;
import com.mendez.app.jpa.models.Reservacion;

@Service
public class ReservacionesService implements IService<Reservacion, Reservacion>{
	
	//atributos
	
		@Autowired
		private IReservacionDao reservacionesDao;
		
		/*//inyecta la depedencia
		private ISalonDao salonesDao;
		private IClienteDao clientesDao;
		private IDetalleReservacionDao detalleReservacionDao;*/
		
		
		
		//metodos

		@Override
		public List<Reservacion> listar() {
			List<Reservacion> reservaciones = new ArrayList<Reservacion>();
			reservaciones = (List<Reservacion>)reservacionesDao.findAll();
			return reservaciones;
		}

		@Override
		public Optional<Reservacion> getById(Long id) {
			// TODO Auto-generated method stub
			Optional<Reservacion> reservacion = reservacionesDao.findById(id);
			return reservacion;
		}

		@Override
		public void guardar(Reservacion t) {
			// TODO Auto-generated method stub
			this.reservacionesDao.save(t);

			
		}

		@Override
		public void eliminar(Long id) {
			// TODO Auto-generated method stub
			this.reservacionesDao.deleteById(id);
			
		}
		
		/*//metodo para convertir DTO en un modelo original
		public Reservacion  convertirDTOaReservacion (ReservacionDTO reservaciondto) {
			Reservacion r = new Reservacion();
			r.setId(reservaciondto.getId());
			r.setFechaInicio(reservaciondto.getFechaInicio());
			r.setHoraInicio(reservaciondto.getHoraInicio());
			r.setFechaFin(reservaciondto.getFechaFin());
			r.setHoraFin(reservaciondto.getHoraFin());
			r.setEstadoReservacion(reservaciondto.getEstadoReservacion());
			r.setSalon(salonesDao.findById(reservaciondto.getSalon()).get());
			r.setCliente(clientesDao.findById(reservaciondto.getCliente()).get());
			r.setDetalle_reservacion(detalleReservacionDao.findById(reservaciondto.getDetalle_reservacion()).get());
			return r;
			
		}*/
		

}
