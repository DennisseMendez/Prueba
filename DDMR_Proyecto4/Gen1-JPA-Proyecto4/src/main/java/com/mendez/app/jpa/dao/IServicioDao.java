package com.mendez.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.mendez.app.jpa.models.Servicio;


public interface IServicioDao extends CrudRepository<Servicio, Long>{

}
