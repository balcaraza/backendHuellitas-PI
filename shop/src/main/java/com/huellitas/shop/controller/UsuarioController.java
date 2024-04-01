package com.huellitas.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huellitas.shop.dto.ChangePassword;
import com.huellitas.shop.model.Usuarios;
import com.huellitas.shop.service.UsuarioService;

@RestController
@RequestMapping(path = "/api/registro/") // http://localhost:8080/api/registro/
public class UsuarioController {
	private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}// constructor

	// Get
	@GetMapping
	public List<Usuarios> getUsuarios() {
		return usuarioService.getAllUsuarios();
	}// método getUsuarios

	// GET que solo traiga un usuario
	@GetMapping(path = "{usuaId}") // http://localhost:8080/api/registro/1
	public Usuarios getUsuario(@PathVariable("usuaId") Long usuaId) {
		return usuarioService.getUsuario(usuaId);
	}// método getUsuario

	// POST
	@PostMapping
	public Usuarios addUsuario(@RequestBody Usuarios usuario) { // http://localhost:8080/api/registro/
		return usuarioService.addUsuario(usuario);
	}// método addUsuario
		
	// DELETE
	@DeleteMapping(path = "{usuaId}") // http://localhost:8080/api/products/1
	public Usuarios deleteUsuario(@PathVariable("usuaId")Long usuaId) {
		return usuarioService.deleteUsuario(usuaId);
	}// método deleteUsuario

	// PUT
	@PutMapping(path = "{usuaId}") // http://localhost:8080/api/products/2
	public Usuarios updateUsuario(@PathVariable("usuaId") Long usuaId, @RequestBody ChangePassword changePassword) {
		return usuarioService.updateUsuario(usuaId, changePassword);
	}// Método updateProduct

}
