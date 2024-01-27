package com.mendez.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.mendez.app.jpa.models.Reservacion;

public interface IReservacionDao extends CrudRepository<Reservacion, Long>{

}
