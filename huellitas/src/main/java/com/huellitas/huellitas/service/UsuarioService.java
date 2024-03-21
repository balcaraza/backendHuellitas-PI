package com.huellitas.huellitas.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.huellitas.huellitas.model.Usuarios;

@Service
public class UsuarioService {
	public final ArrayList<Usuarios> list = new ArrayList<Usuarios>();

	public UsuarioService() {
		list.add(new Usuarios("Balam Balcaraza", "5588062943", "balcaraza@gmail.com", "Huellitas_123", 1));
		list.add(new Usuarios("Monserrat Cervantes", "3331777101", "dianaranda2408@gmail.com", "Huellitas_123", 1));
	}// constructor

	public ArrayList<Usuarios> getAllUsuarios() {
		return list;
	}//getAllUsuarios

	public Usuarios getUsuario(int usuaId) {
		Usuarios tmpUser = null;
		for (Usuarios usuario : list) {
			if (usuario.getNo_usuario() == usuaId) {
				tmpUser = usuario;
				break;
			}//if ==
		}//forEach
		return tmpUser;
	}//getProduct

	public Usuarios addUsuario(Usuarios usuario) {
		Usuarios tmpUser = null;
		if (list.add(usuario)) {
			tmpUser= usuario;
		}//if
		return tmpUser;
	}//addUsuario

	public Usuarios deleteUsuario(int usuaId) {
		Usuarios tmpUser = null;
		for (Usuarios usuario : list) {
			if (usuario.getNo_usuario() == usuaId) {
				tmpUser = usuario;
				list.remove(usuario);//borra el producto en la lista
				break;
			}//if ==
		}//forEach
		return tmpUser;
	}//deleteUsuario

	public Usuarios updateUsuario(int usuaId, String nombre, String telefono, String correo_electronico,
			String password_usuario, Integer roles_id_rol) {
		Usuarios tmpUser =null;
		for (Usuarios usuario : list) {
			if (usuario.getNo_usuario() == usuaId) {
				if(nombre.length()!=0) usuario.setNombre(nombre);
				if(telefono.length()!=0) usuario.setTelefono(telefono);
				if(correo_electronico.length()!=0) usuario.getCorreo_electronico();
				if(password_usuario.length()!=0) usuario.setPassword_usuario(password_usuario);
				if(roles_id_rol.intValue()>0) usuario.setRoles_id_rol(roles_id_rol);
				tmpUser = usuario;
				break;
			}//if ==
		}
		return tmpUser;
	}//updateUsuario


}//class UsuarioService
