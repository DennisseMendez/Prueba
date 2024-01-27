package com.mendez.app.jpa.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//1
@Table(name = "jpa_servicios")
@Entity
public class Servicio {
	//2
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ3")
	@SequenceGenerator(sequenceName = "customer_seq3", allocationSize = 1, name = "CUST_SEQ3")
	private Long id;
	
	//2
	@Column (name = "nombre")
	private String nombre;
	
	//2
	@Column (name = "descripcion")
	private String descripcion;
	
	//2
	@Column (name = "cantidad")
	private Long cantidad;
	
	//2
	@Column (name = "precio")
	private Float precio;
	
	
	
	//3
	@JoinColumn(name = "detalle_reservacion_id")
	@ManyToOne
	private DetalleReservacion detalle_reservacion;
	
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public DetalleReservacion getDetalle_reservacion() {
		return detalle_reservacion;
	}

	public void setDetalle_reservacion(DetalleReservacion detalle_reservacion) {
		this.detalle_reservacion = detalle_reservacion;
	}

	
	
	
}
