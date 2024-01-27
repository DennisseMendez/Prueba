package com.mendez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendez.app.jpa.dao.IClienteDao;
import com.mendez.app.jpa.models.Cliente;

@Service
public class ClientesService implements IService<Cliente, Cliente >{
	
	//atributos
	
		@Autowired
		private IClienteDao clientesDao;
		
		
		
		
		//metodos

		@Override
		public List<Cliente> listar() {
			List<Cliente> clientes = new ArrayList<Cliente>();
			clientes = (List<Cliente>)clientesDao.findAll();
			return clientes;
		}

		@Override
		public Optional<Cliente> getById(Long id) {
			// TODO Auto-generated method stub
			Optional<Cliente> salon = clientesDao.findById(id);
			return salon;
		}

		@Override
		public void guardar(Cliente t) {
			// TODO Auto-generated method stub
			this.clientesDao.save(t);
			
		}

		@Override
		public void eliminar(Long id) {
			// TODO Auto-generated method stub
			this.clientesDao.deleteById(id);
			
		}
		

}
