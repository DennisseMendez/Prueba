package com.mendez.app.jpa.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//1
@Table(name = "jpa_reservaciones")
@Entity
public class Reservacion {
	
	//2
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ4")
	@SequenceGenerator(sequenceName = "customer_seq4", allocationSize = 1, name = "CUST_SEQ4")
	private Long id;
	
	//2
	@Column(name = "FechaInicio")
	private Date fechaInicio;
	
	
	//2
	@Column(name = "HoraInicio")
	private String horaInicio;
	
	//2
	@Column(name = "FechaFin")
	private Date fechaFin;
	
	//2
	@Column(name = "HoraFin")
	private String horaFin;
	
	//2
	@Column(name = "EstadoReservacion")
	private String estadoReservacion;
	
	//3
	@JoinColumn(name = "salon_id")
	@ManyToOne
	private Salon salon;
	
	//3
	@JoinColumn(name = "cliente_id")
	@ManyToOne
	private Cliente cliente;

	//3
	@JoinColumn(name = "detalle_reservacion_id")
	@OneToOne
	private DetalleReservacion detalle_reservacion;
	
	
	//Getters and Setters

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

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public DetalleReservacion getDetalle_reservacion() {
		return detalle_reservacion;
	}

	public void setDetalle_reservacion(DetalleReservacion detalle_reservacion) {
		this.detalle_reservacion = detalle_reservacion;
	}
	
	
	
	
}
