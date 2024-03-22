package com.huellitas.huellitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO plain Old Java Object
@Entity
@Table(name="Usuarios")
public class Usuarios {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="no_usuario", unique=true, nullable=false)
	private Long no_usuario;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String telefono;
	@Column(name="correo_electronico", nullable=false)
	private String correo;
	@Column(nullable=false)
	private String password_usuario;
	@Column(name="roles_id_rol", nullable=false)
	private Integer idRol;
	
	//1.-Constructor
	public Usuarios(String nombre, String telefono, String correo, String password_usuario,
			Integer idRol) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.password_usuario = password_usuario;
		this.idRol = idRol;
	}//Constructor

    //1.1.-Constructor Vacio//Post
	public Usuarios() {}//constructor

	//2.-Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo){
		this.correo = correo;
	}

	public String getPassword_usuario() {
		return password_usuario;
	}

	public void setPassword_usuario(String password_usuario) {
		this.password_usuario = password_usuario;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public Long getNo_usuario() {
		return no_usuario;
	}
	//3.-toString
	@Override
	public String toString() {
		return "Usuarios [no_usuario=" + no_usuario + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", correo=" + correo + ", password_usuario=" + password_usuario
				+ ", idRol=" + idRol + "]";
	}
	
	
		

}//class Usuarios
