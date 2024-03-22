package com.huellitas.huellitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Roles {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	 private Long id_rol;
	@Column(nullable=false)
	 private String tipo_rol;
	 //constructores
	public Roles(String tipo_rol) {
		super();
		this.tipo_rol = tipo_rol;
	}

	public Roles() {}
//getters and setters
	public Long getId_rol() {
		return id_rol;
	}
	public String getTipo_rol() {
		return tipo_rol;
	}

	public void setTipo_rol(String tipo_rol) {
		this.tipo_rol = tipo_rol;
	}
	//toString
	@Override
	public String toString() {
		return "Roles [tipo_rol=" + tipo_rol + ", id_rol=" + id_rol + "]";
	}

}
