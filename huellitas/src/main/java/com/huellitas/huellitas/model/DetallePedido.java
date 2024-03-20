package com.huellitas.huellitas.model;

public class DetallePedido {
	private int id_detalle_compra;
	private String nombre_completo;
	private String calle; 
	private String municipio; 
	private String estado; 
	private String codigo_postal; 
	private String num_int_ext; 
	private String telefono; 
	private String instrucciones; 
	private String usuario_no_usuario; 
	private String usuario_roles_id_rol; 
	private static int total =0;
	public DetallePedido(int id_detalle_compra, String nombre_completo, String calle, String municipio, String estado,
			String codigo_postal, String num_int_ext, String telefono, String instrucciones, String usuario_no_usuario,
			String usuario_roles_id_rol) {
		super();
		DetallePedido.total++;
		id_detalle_compra = DetallePedido.total;
		this.nombre_completo = nombre_completo;
		this.calle = calle;
		this.municipio = municipio;
		this.estado = estado;
		this.codigo_postal = codigo_postal;
		this.num_int_ext = num_int_ext;
		this.telefono = telefono;
		this.instrucciones = instrucciones;
		this.usuario_no_usuario = usuario_no_usuario;
		this.usuario_roles_id_rol = usuario_roles_id_rol;
	}
	public DetallePedido() {
		DetallePedido.total++;
		id_detalle_compra = DetallePedido.total;
	}
	//getters y setters
	public int getId_detalle_compra() {
		return id_detalle_compra;
	}
	public void setId_detalle_compra(int id_detalle_compra) {
		this.id_detalle_compra = id_detalle_compra;
	}
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCodigo_postal() {
		return codigo_postal;
	}
	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}
	public String getNum_int_ext() {
		return num_int_ext;
	}
	public void setNum_int_ext(String num_int_ext) {
		this.num_int_ext = num_int_ext;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getInstrucciones() {
		return instrucciones;
	}
	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}
	public String getUsuario_no_usuario() {
		return usuario_no_usuario;
	}
	public void setUsuario_no_usuario(String usuario_no_usuario) {
		this.usuario_no_usuario = usuario_no_usuario;
	}
	public String getUsuario_roles_id_rol() {
		return usuario_roles_id_rol;
	}
	public void setUsuario_roles_id_rol(String usuario_roles_id_rol) {
		this.usuario_roles_id_rol = usuario_roles_id_rol;
	}
	public static int getTotal() {
		return total;
	}
	public static void setTotal(int total) {
		DetallePedido.total = total;
	}
	//toString
	@Override
	public String toString() {
		return "DetallePedido [id_detalle_compra=" + id_detalle_compra + ", nombre_completo=" + nombre_completo
				+ ", calle=" + calle + ", municipio=" + municipio + ", estado=" + estado + ", codigo_postal="
				+ codigo_postal + ", num_int_ext=" + num_int_ext + ", telefono=" + telefono + ", instrucciones="
				+ instrucciones + ", usuario_no_usuario=" + usuario_no_usuario + ", usuario_roles_id_rol="
				+ usuario_roles_id_rol + "]";
	}
	
	
}
