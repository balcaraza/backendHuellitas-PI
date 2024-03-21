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

import com.huellitas.huellitas.model.Roles;
import com.huellitas.huellitas.service.ServicioId;

@RestController
@RequestMapping ("/api/roles/")
public class ControladorId {
	private final ServicioId servicioid;
	@Autowired
	public ControladorId(ServicioId servicioid) {
		this.servicioid = servicioid;
	}//controlador
	@GetMapping
	ArrayList<Roles> getRoles (){
	return servicioid.getRoles();
	}
	@GetMapping (path="{id_rol}")
	public Roles getRol (@PathVariable ("id_rol")int id_rol) {
		return servicioid.getRol(id_rol);
	}
	@PostMapping
	public Roles addRol (@RequestBody Roles roles ) {
		return servicioid.addRol(roles);
	}
	@DeleteMapping (path="{id_rol}")
	public Roles deleteRol (@PathVariable ("id_rol")int id_rol) {
		return  servicioid.deleteRol(id_rol);
	}
	@PutMapping (path="{id_rol}")
	public Roles updateRol (@PathVariable ("id_rol")int id_rol,
			@RequestBody Roles roles) {
		return servicioid.updateRol(id_rol, roles.getTipo_rol());
	}
	
	
  }

