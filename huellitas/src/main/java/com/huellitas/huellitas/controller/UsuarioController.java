package com.huellitas.huellitas.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huellitas.huellitas.model.Usuarios;
import com.huellitas.huellitas.service.UsuarioService;

@RestController
@RequestMapping(path="/api/usuarios/") // http://localhost:8080/api/usuarios/
public class UsuarioController {
	private final UsuarioService usuarioService;
    @Autowired
	public UsuarioController(UsuarioService usuarioService) {
    	this.usuarioService=usuarioService;
	}//constructor

	//Get
	@GetMapping 
	public ArrayList<Usuarios> getUsuarios() {
		return usuarioService.getAllUsuarios();
	}// método getUsuarios
	
	//GET que solo traiga un usuario
		@GetMapping(path = "{usuaId}") // http://localhost:8080/api/usuarios/1
		public Usuarios getUsuario(@PathVariable("usuaId") int usuaId) {
			return usuarioService.getUsuario(usuaId);
		}// método getUsuario
	
		//POST
		@PostMapping
		public Usuarios addUsuario(@RequestBody Usuarios usuario) { // http://localhost:8080/api/usuarios/
			return usuarioService.addUsuario(usuario);
		}// método addUsuario
		//DELETE
		@DeleteMapping(path = "{usuaId}") // http://localhost:8080/api/products/1
		public Usuarios deleteUsuario(@PathVariable("usuaId") int usuaId) {
			return usuarioService.deleteUsuario(usuaId);
		}// método deleteUsuario
		// PUT
		@PutMapping(path = "{usuaId}") // http://localhost:8080/api/products/2
		public Usuarios updateUsuario(@PathVariable("usuaId") int usuaId, @RequestBody Usuarios usuario) {
			return usuarioService.updateUsuario(usuaId, usuario.getNombre(),usuario.getTelefono(), 
					usuario.getCorreo_electronico(), usuario.getPassword_usuario(),
					Integer.valueOf(usuario.getRoles_id_rol()));
		}// Método updateProduct 2da Forma
}//class UsuarioController
