package com.mendez.app.jpa.dtos;

public class ServicioDTO {
	
	private Long id;
	private String nombre;
	private String descripcion;
	private Long cantidad;
	private Float precio;
	private Long detalle_reservacion;
	
	
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
	public Long getDetalle_reservacion() {
		return detalle_reservacion;
	}
	public void setDetalle_reservacion(Long detalle_reservacion) {
		this.detalle_reservacion = detalle_reservacion;
	}
	
	
	


}
