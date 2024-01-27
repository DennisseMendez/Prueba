package com.mendez.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.mendez.app.jpa.models.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}
