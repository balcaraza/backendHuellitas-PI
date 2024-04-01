package com.huellitas.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huellitas.shop.dto.ChangePassword;
import com.huellitas.shop.model.Usuarios;
import com.huellitas.shop.repository.UsuarioRepository;

@Service
public class UsuarioService {
	public final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}// constructor

	// Métodos de GET
	public List<Usuarios> getAllUsuarios() {
		return usuarioRepository.findAll();
	}// getAllUsuarios

	public Usuarios getUsuario(Long usuaId) {
		return usuarioRepository.findById(usuaId)
				.orElseThrow(() -> new IllegalArgumentException("El usuario con el id [" + usuaId + "] no existe "));
	}// getUsuario

	// Método para DELETE
	public Usuarios deleteUsuario(Long usuaId) {
		Usuarios tmpUser = null;
		if (usuarioRepository.existsById(usuaId)) {
			tmpUser = usuarioRepository.findById(usuaId).get();
			usuarioRepository.deleteById(usuaId);
		} // if exist
		return tmpUser;
	}// deleteUsuario

	// Método para POST
	public Usuarios addUsuario(Usuarios usuario) {
		Usuarios tmpUser = null;
		if (usuarioRepository.findByCorreo(usuario.getCorreo()).isEmpty()) {
			tmpUser = usuarioRepository.save(usuario);
		} else {
			System.out.println("El usuario con este email [" + usuario.getCorreo() + "] ya esta registrado");
		}
		return tmpUser;
	}// addUsuario
	
	//Método para PUT
		public Usuarios updateUsuario(Long usuaId, ChangePassword changePassword) {
		Usuarios tmpUser =null;
		if (usuarioRepository.existsById(usuaId)) {
			tmpUser=usuarioRepository.findById(usuaId).get();
			if(changePassword.getPassword().length()!=0) {
			if (tmpUser.getPassword_usuario().equals(changePassword.getPassword())) {
				tmpUser.setPassword_usuario(changePassword.getNpassword());
			}else {
				System.out.println("update -El Password del usuario["+
						tmpUser.getNo_usuario()+ "] no coincide");
				if(changePassword.getNombre().length()!=0) tmpUser.setNombre(changePassword.getNombre());;
				if(changePassword.getTelefono().length()!=0) tmpUser.setTelefono(changePassword.getTelefono());
			}}//if else equals
			if(changePassword.getNombre().length()!=0) tmpUser.setNombre(changePassword.getNombre());;
			if(changePassword.getTelefono().length()!=0) tmpUser.setTelefono(changePassword.getTelefono());
			usuarioRepository.save(tmpUser);
		}//if exist
		return tmpUser;
	}//updateUsuario

}
