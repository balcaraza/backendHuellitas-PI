package com.huellitas.huellitas.model;

public class Usuarios {
	private int no_usuario;
	private String nombre;
	private String telefono;
	private String correo_electronico;
	private String password_usuario;
	private static int total=0;
	
	public Usuarios(int no_usuario, String nombre, String telefono, String correo_electronico,
			String password_usuario) {
		super();
		Usuarios.total++;
		no_usuario = Usuarios.total;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo_electronico = correo_electronico;
		this.password_usuario = password_usuario;
	}

	public Usuarios() {
		Usuarios.total++;
		no_usuario = Usuarios.total;
	}
//getters and setters
	public int getNo_usuario() {
		return no_usuario;
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

	public String getCorreo_electronico() {
		return correo_electronico;
	}
//to string
	@Override
	public String toString() {
		return "Usuarios [no_usuario=" + no_usuario + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", correo_electronico=" + correo_electronico + ", password_usuario=" + password_usuario + "]";
	}

	public String getPassword_usuario() {
		return password_usuario;
	}

	public void setPassword_usuario(String password_usuario) {
		this.password_usuario = password_usuario;
	}

	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		Usuarios.total = total;
	}
	
	
}
