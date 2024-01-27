package com.mendez.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.mendez.app.jpa.models.Salon;

public interface ISalonDao extends CrudRepository<Salon, Long> {

	

}
