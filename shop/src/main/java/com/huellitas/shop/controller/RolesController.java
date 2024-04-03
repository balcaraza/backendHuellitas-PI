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

import com.huellitas.shop.model.Roles;
import com.huellitas.shop.service.RolesService;

@RestController
@RequestMapping (path="/api/roles/")
public class RolesController {
	private final RolesService rolesService;
	@Autowired
	public RolesController(RolesService rolesService) {
		this.rolesService = rolesService;
	}//controlador
	@GetMapping
	public List<Roles> getRoles (){
	return rolesService.getRoles();
	}
	@GetMapping (path="{id_rol}")
	public Roles getRol (@PathVariable ("id_rol")Long id_rol) {
		return rolesService.getRol(id_rol);
	}
	@PostMapping
	public Roles addRol (@RequestBody Roles roles ) {
		return rolesService.addRol(roles);
	}
	@DeleteMapping (path="{id_rol}")
	public Roles deleteRol (@PathVariable ("id_rol")Long id_rol) {
		return  rolesService.deleteRol(id_rol);
	}
	@PutMapping (path="{id_rol}")
	public Roles updateRol (@PathVariable ("id_rol")Long id_rol,
			@RequestBody Roles roles) {
		return rolesService.updateRol(id_rol, roles.getTipoRol());
	}
}
