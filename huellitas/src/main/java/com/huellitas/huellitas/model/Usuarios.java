package com.huellitas.huellitas.model;

public class Usuarios {
	private int no_usuario;
	private String nombre;
	private String telefono;
	private String correo_electronico;
	private String password_usuario;
	private int roles_id_rol;
	private static int total=0;
	public Usuarios(int no_usuario, String nombre, String telefono, String correo_electronico, String password_usuario,
			int roles_id_rol) {
		super();
		Usuarios.total++;
		no_usuario = Usuarios.total;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo_electronico = correo_electronico;
		this.password_usuario = password_usuario;
		this.roles_id_rol = roles_id_rol;
	}
	public Usuarios() {
		Usuarios.total++;
		no_usuario = Usuarios.total;
	}
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
	public String getPassword_usuario() {
		return password_usuario;
	}
	public void setPassword_usuario(String password_usuario) {
		this.password_usuario = password_usuario;
	}
	public int getRoles_id_rol() {
		return roles_id_rol;
	}
	public void setRoles_id_rol(int roles_id_rol) {
		this.roles_id_rol = roles_id_rol;
	}
	public static int getTotal() {
		return total;
	}
	public static void setTotal(int total) {
		Usuarios.total = total;
	}
	@Override
	public String toString() {
		return "Usuarios [no_usuario=" + no_usuario + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", correo_electronico=" + correo_electronico + ", password_usuario=" + password_usuario
				+ ", roles_id_rol=" + roles_id_rol + "]";
	}
	
	
}
