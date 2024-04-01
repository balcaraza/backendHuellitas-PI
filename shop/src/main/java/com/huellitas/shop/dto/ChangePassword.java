package com.huellitas.shop.dto;

public class ChangePassword {
	private String password;
	private String npassword;
	private String nombre;
	private String telefono;
	
	
	
	public ChangePassword(String password, String npassword, String nombre, String telefono) {
		super();
		this.password = password;
		this.npassword = npassword;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public ChangePassword() {}//Constructor

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNpassword() {
		return npassword;
	}

	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}

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

	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", npassword=" + npassword + "]";
	}
}
