package com.mendez.app.jpa.dtos;

import java.sql.Date;




public class ReservacionDTO {
	
	private Long id;
	private Date fechaInicio;
	private String horaInicio;
	private Date fechaFin;
	private String horaFin;
	private String estadoReservacion;
	private Long salon;
	private Long cliente;
	private Long detalle_reservacion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public String getEstadoReservacion() {
		return estadoReservacion;
	}
	public void setEstadoReservacion(String estadoReservacion) {
		this.estadoReservacion = estadoReservacion;
	}
	public Long getSalon() {
		return salon;
	}
	public void setSalon(Long salon) {
		this.salon = salon;
	}
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	public Long getDetalle_reservacion() {
		return detalle_reservacion;
	}
	public void setDetalle_reservacion(Long detalle_reservacion) {
		this.detalle_reservacion = detalle_reservacion;
	}

	
	






}
