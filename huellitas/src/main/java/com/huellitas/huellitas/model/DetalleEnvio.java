package com.huellitas.huellitas.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalle_envio")
public class DetalleEnvio {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_detalle_envio", unique=true, nullable=false)
	private Long detalleEnvioId;
	@Column(nullable=false)
	private String nombre_completo;
	@Column(nullable=false)
	private String calle;
	@Column(nullable=false)
	private String municipio;
	@Column(nullable=false)
	private String estado;
	@Column(nullable=false)
	private String codigo_postal;
	@Column(nullable=false)
	private String num_int_ext;
	@Column(nullable=false)
	private String telefono;
	private String instrucciones;
	@Column(nullable=false)
	private Long usuarios_no_usuario;
	@Column(nullable=false)
	private int usuarios_roles_id_rol;
	
	//constructor
	public DetalleEnvio( String nombre_completo, String calle, String municipio, String estado,
			String codigo_postal, String num_int_ext, String telefono, String instrucciones) {
		super();
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
	}//constructor
	//getters y setters
	public Long getDetalleEnvioId() {
		return detalleEnvioId;
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

	public Long getUsuarios_no_usuario() {
		return usuarios_no_usuario;
	}//getPedidos_np_usuario
	public int getUsuarios_roles_id_rol() {
		return usuarios_roles_id_rol;
	}//getUsuarios_roles_id_rol
	@Override
	public String toString() {
		return "DetalleEnvio [detalleEnvioId=" + detalleEnvioId + ", nombre_completo=" + nombre_completo
				+ ", calle=" + calle + ", municipio=" + municipio + ", estado=" + estado + ", codigo_postal="
				+ codigo_postal + ", num_int_ext=" + num_int_ext + ", telefono=" + telefono + ", instrucciones="
				+ instrucciones + ", usuarios_no_usuario=" + usuarios_no_usuario + ", usuarios_roles_id_rol=" 
				+ usuarios_roles_id_rol + "]";
	}//toString
	
}//class DetalleEnvio
