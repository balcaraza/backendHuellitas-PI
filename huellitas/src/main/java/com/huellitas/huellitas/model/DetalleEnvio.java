package com.huellitas.huellitas.model;

public class DetalleEnvio {
	private int id_detalle_compra;
	private String nombre_completo;
	private String calle;
	private String municipio;
	private String estado;
	private String codigo_postal;
	private String num_int_ext;
	private String telefono;
	private String instrucciones;
	private static int total = 0;
	//constructor
	public DetalleEnvio( String nombre_completo, String calle, String municipio, String estado,
			String codigo_postal, String num_int_ext, String telefono, String instrucciones) {
		super();
		DetalleEnvio.total++;
		id_detalle_compra = DetalleEnvio.total;
		this.nombre_completo = nombre_completo;
		this.calle = calle;
		this.municipio = municipio;
		this.estado = estado;
		this.codigo_postal = codigo_postal;
		this.num_int_ext = num_int_ext;
		this.telefono = telefono;
		this.instrucciones = instrucciones;
	}//constructor
	public DetalleEnvio() {
		DetalleEnvio.total++;
		id_detalle_compra = DetalleEnvio.total;
	}//constructor
	//getters y setters
	public int getId_detalle_compra() {
		return id_detalle_compra;
	}//getId_detalle_compra
	public String getNombre_completo() {
		return nombre_completo;
	}//getNombre_completo
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}//setNombre_completo
	public String getCalle() {
		return calle;
	}//getCalle
	public void setCalle(String calle) {
		this.calle = calle;
	}//setCalle
	public String getMunicipio() {
		return municipio;
	}//getMunicipio
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}//setMunicipio
	public String getEstado() {
		return estado;
	}//getEstado
	public void setEstado(String estado) {
		this.estado = estado;
	}//setEstado
	public String getCodigo_postal() {
		return codigo_postal;
	}//getCodigo_postal
	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}//setCodigo_postal
	public String getNum_int_ext() {
		return num_int_ext;
	}//getNum_int_ext
	public void setNum_int_ext(String num_int_ext) {
		this.num_int_ext = num_int_ext;
	}//setNum_int_ext
	public String getTelefono() {
		return telefono;
	}//getTelefono
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}//setTelefono
	public String getInstrucciones() {
		return instrucciones;
	}// getInstrucciones
	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}// setInstrucciones
	public static int getTotal() {
		return total;
	}//getTotal
	public static void setTotal(int total) {
		DetalleEnvio.total = total;
	}//setTotal
	//toString
	@Override
	public String toString() {
		return "DetalleEnvio [id_detalle_compra=" + id_detalle_compra + ", nombre_completo=" + nombre_completo
				+ ", calle=" + calle + ", municipio=" + municipio + ", estado=" + estado + ", codigo_postal="
				+ codigo_postal + ", num_int_ext=" + num_int_ext + ", telefono=" + telefono + ", instrucciones="
				+ instrucciones + "]";
	}//toString

	

}//class DetalleEnvio
