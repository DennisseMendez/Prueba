package com.mendez.app.jpa.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//1
@Table(name = "jpa_salones")
@Entity
public class Salon {
	
	//1
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ1")
	@SequenceGenerator(sequenceName = "customer_seq1", allocationSize = 1, name = "CUST_SEQ1")
	private Long id;
	
	//2
	@Column(name = "nombre")
	private String nombre;
	
	//2
	@Column (name = "capacidad")
	private Integer capacidad;
	
	//2
	@Column (name = "descripcion")
	private String descripcion;
	
	//2
	@Column (name = "disponibilidad")
	private Boolean disponibilidad;
	
	
	//volteamos la relacion  original
	@OneToMany(mappedBy = "salon")
	private List<Reservacion> detalle;
	
	//Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public List<Reservacion> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<Reservacion> detalle) {
		this.detalle = detalle;
	}
	
	
	
	
	

}
