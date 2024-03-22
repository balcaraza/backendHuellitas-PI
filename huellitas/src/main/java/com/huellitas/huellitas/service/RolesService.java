package com.huellitas.huellitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huellitas.huellitas.model.Roles;
import com.huellitas.huellitas.repository.RolesRepository;
@Service
public class RolesService {
	public final RolesRepository rolesRepository;
	@Autowired
	public RolesService( RolesRepository rolesRepository) {
		this.rolesRepository = rolesRepository;
	}
	public List<Roles> getRoles() {
		return rolesRepository.findAll();
	}
	public Roles getRol(Long id_rol) {
		return rolesRepository.findById(id_rol).orElseThrow(
				()-> new IllegalArgumentException("El rol id["+
						id_rol + "] no existe"));
	}

	public Roles addRol(Roles roles) {
		Optional<Roles> temp = rolesRepository.findByTipoRol(roles.getTipo_rol());
		if (temp.isEmpty()) {
			return rolesRepository.save(roles);
		}else {
			System.out.println("Ya existe el rol["+
					roles.getTipo_rol()+ "]");
			return null;
		} //if
	}//addProduct


	public Roles deleteRol(Long id_rol) {
		Roles temp = null;
		if(rolesRepository.existsById(id_rol)) {
			rolesRepository.deleteById(Long.valueOf(id_rol));
		}
	return temp;
	}//deleteUser

	public Roles updateRol(Long id_rol, String tipo_rol) {
		Roles roles = null;
		if(rolesRepository.existsById(id_rol)) {
			roles = rolesRepository.findById(id_rol).get();
				if (tipo_rol.length()!=0) roles.setTipo_rol(tipo_rol);
				rolesRepository.save(roles);
		}//exists
		return roles;
	}//updateUser
}
