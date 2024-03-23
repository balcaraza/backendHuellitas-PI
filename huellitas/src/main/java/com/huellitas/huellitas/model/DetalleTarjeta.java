package com.huellitas.huellitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalle_tarjeta")
public class DetalleTarjeta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pago", unique=true, nullable=false)
	private Long idPago;
	@Column(nullable=false, name="nombreTarjeta")
	private String nombreTarjeta;
	@Column(nullable=false, name="no_tarjeta")
	private String numeroTarjeta;
	@Column(nullable=false)
	private int mes;
	@Column(nullable=false)
	private int anio;
	@Column(nullable=false)
	private String codigo_seguridad;
	
	public DetalleTarjeta(String nombreTarjeta, String numeroTarjeta, int mes, int anio,
			String codigo_seguridad) {
		super();
		this.nombreTarjeta = nombreTarjeta;
		this.numeroTarjeta = numeroTarjeta;
		this.mes = mes;
		this.anio = anio;
		this.codigo_seguridad = codigo_seguridad;
	}

	public DetalleTarjeta() {
	
	}
	
	//getters y setters
	public Long getId_pago() {
		return idPago;
	}
	public String getNombre_tarjeta() {
		return nombreTarjeta;
	}

	public void setNombre_tarjeta(String nombreTarjeta) {
		this.nombreTarjeta = nombreTarjeta;
	}

	public String getNo_tarjeta() {
		return numeroTarjeta;
	}

	public void setNo_tarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getCodigo_seguridad() {
		return codigo_seguridad;
	}

	public void setCodigo_seguridad(String codigo_seguridad) {
		this.codigo_seguridad = codigo_seguridad;
	}

	//toString
	@Override
	public String toString() {
		return "DetalleTarjeta [idPago=" + idPago + ", nombreTarjeta=" + nombreTarjeta + ", numeroTarjeta="
				+ numeroTarjeta + ", mes=" + mes + ", anio=" + anio + ", codigo_seguridad=" + codigo_seguridad + "]";
	}	
}
