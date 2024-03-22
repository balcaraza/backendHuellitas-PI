package com.huellitas.huellitas.model;

public class Roles {
	private String tipo_rol;
	 private int id_rol;
	 private static int total =0;
	 //constructores
	public Roles(String tipo_rol) {
		super();
		this.tipo_rol = tipo_rol;
		Roles.total++;
		id_rol = Roles.total;
	}

	public Roles() {
		Roles.total++;
		id_rol = Roles.total;
	}
//getters and setters
	public String getTipo_rol() {
		return tipo_rol;
	}

	public void setTipo_rol(String tipo_rol) {
		this.tipo_rol = tipo_rol;
	}

	public int getId_rol() {
		return id_rol;
	}

	public static int getTotal() {
		return total;
	}
	//toString
	@Override
	public String toString() {
		return "Roles [tipo_rol=" + tipo_rol + ", id_rol=" + id_rol + "]";
	}

}
