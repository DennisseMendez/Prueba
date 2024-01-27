package com.mendez.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.mendez.app.jpa.models.DetalleReservacion;

public interface IDetalleReservacionDao extends CrudRepository<DetalleReservacion, Long> {

}
