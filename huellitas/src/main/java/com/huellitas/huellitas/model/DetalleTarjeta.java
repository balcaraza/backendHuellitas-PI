package com.huellitas.huellitas.model;

public class DetalleTarjeta {
	private int id_pago;
	private String nombre_tarjeta;
	private String no_tarjeta;
	private int mes;
	private int anio;
	private String codigo_seguridad;
	private static int total = 0;
	
	public DetalleTarjeta(String nombre_tarjeta, String no_tarjeta, int mes, int anio,
			String codigo_seguridad) {
		super();
		DetalleTarjeta.total++;
		id_pago = DetalleTarjeta.total;
		this.nombre_tarjeta = nombre_tarjeta;
		this.no_tarjeta = no_tarjeta;
		this.mes = mes;
		this.anio = anio;
		this.codigo_seguridad = codigo_seguridad;
	}

	public DetalleTarjeta() {
		DetalleTarjeta.total++;
		id_pago = DetalleTarjeta.total;
	}
//getters y setters
	public int getId_pago() {
		return id_pago;
	}
	public String getNombre_tarjeta() {
		return nombre_tarjeta;
	}

	public void setNombre_tarjeta(String nombre_tarjeta) {
		this.nombre_tarjeta = nombre_tarjeta;
	}

	public String getNo_tarjeta() {
		return no_tarjeta;
	}

	public void setNo_tarjeta(String no_tarjeta) {
		this.no_tarjeta = no_tarjeta;
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

	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		DetalleTarjeta.total = total;
	}
//toString
	@Override
	public String toString() {
		return "DetalleTarjeta [id_pago=" + id_pago + ", nombre_tarjeta=" + nombre_tarjeta + ", no_tarjeta="
				+ no_tarjeta + ", mes=" + mes + ", anio=" + anio + ", codigo_seguridad=" + codigo_seguridad + "]";
	}

	
	
}
