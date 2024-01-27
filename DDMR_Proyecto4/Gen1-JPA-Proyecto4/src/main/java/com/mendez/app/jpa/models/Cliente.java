

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
@Table(name = "p4_clientes")
@Entity
public class Cliente {
	
	
	//2
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ2")
	@SequenceGenerator(sequenceName = "clientes_seq2", allocationSize = 1, name = "CUST_SEQ2")
	private Long id;
	
	//2
	@Column(name = "nombre")
	private String nombre;
	
	//2
	@Column (name = "ap_paterno")
	private String apPaterno;
	
	//2
	@Column (name = "ap_materno")
	private String apMaterno;
	
	//2
	@Column (name = "correo")
	private String correo;
	
	//2
	@Column (name = "telefono")
	private Integer telefono;
	
	//volteamos la relacion  original
	@OneToMany(mappedBy = "cliente")
	private List<Reservacion> detalle;
	

	
	//getters and setters


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

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public List<Reservacion> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<Reservacion> detalle) {
		this.detalle = detalle;
	}
	
	

}
