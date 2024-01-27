package com.mendez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendez.app.jpa.dao.ISalonDao;
import com.mendez.app.jpa.models.Salon;
@Service
public class SalonesService implements IService<Salon, Salon>{
	
	//atributos
	
	@Autowired
	private ISalonDao salonesDao;
	
	
	
	
	//metodos

	@Override
	public List<Salon> listar() {
		List<Salon> salones = new ArrayList<Salon>();
		salones = (List<Salon>)salonesDao.findAll();
		return salones;
	}

	@Override
	public Optional<Salon> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Salon> salon = salonesDao.findById(id);
		return salon;
	}

	@Override
	public void guardar(Salon t) {
		// TODO Auto-generated method stub
		this.salonesDao.save(t);
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.salonesDao.deleteById(id);
		
	}
	

}
