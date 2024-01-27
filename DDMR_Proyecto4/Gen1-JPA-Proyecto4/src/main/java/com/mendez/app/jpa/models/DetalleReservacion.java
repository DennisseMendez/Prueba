package com.mendez.app.jpa.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//1
@Table(name = "jpa_detalle_reservacion")
@Entity
public class DetalleReservacion {
	
	//2
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ5")
	@SequenceGenerator(sequenceName = "customer_seq5", allocationSize = 1, name = "CUST_SEQ5")
	private Long id;
	
	
	
	//2
	@Column (name = "total")
	private Float total;
	
	//volteamos la relacion  original
	@OneToOne(mappedBy = "detalle_reservacion")
	private Reservacion detalle;
	
	
	
	/*//volteamos la relacion  original
	
	@OneToMany(mappedBy = "detalle_reservacion")
	private List<Servicio> servicio;*/

	
	//Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	


	/*public List<Servicio> getServicio() {
		return servicio;
	}

	public void setServicio(List<Servicio> servicio) {
		this.servicio = servicio;
	}*/

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Reservacion getDetalle() {
		return detalle;
	}

	public void setDetalle(Reservacion detalle) {
		this.detalle = detalle;
	}

	
	
	

	
	

}
