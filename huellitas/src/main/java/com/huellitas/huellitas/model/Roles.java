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
	@Column(unique=true, nullable=false)
	 private Long id_rol;
	@Column(nullable=false)
	 private String tipoRol;
	 //constructores
	public Roles(String tipoRol) {
		super();
		this.tipoRol = tipoRol;
	}

	public Roles() {}
//getters and setters
	public Long getId_rol() {
		return id_rol;
	}
	public String getTipoRol() {
		return tipoRol;
	}
	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}
	//toString
	@Override
	public String toString() {
		return "Roles [tipoRol=" + tipoRol + ", id_rol=" + id_rol + "]";
	}

}
