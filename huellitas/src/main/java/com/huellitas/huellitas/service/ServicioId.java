package com.huellitas.huellitas.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.huellitas.huellitas.model.Roles;
@Service
public class ServicioId {
public final ArrayList<Roles>list=new ArrayList<Roles>();
public ServicioId() {
	list.add( new Roles("Cliente"));
	list.add( new Roles("Administrador"));

}


	public ArrayList<Roles> getRoles() {
		return list;
	}
	public Roles getRol(int id_rol) {
		Roles temp = null;
		for (Roles roles : list) {
			if (roles.getId_rol()== id_rol) {
				temp = roles;
				break;
			}
		}
		return temp;
	}


	public Roles addRol(Roles roles) {
		Roles temp = null;
		if (list.add(roles)) {
			temp = roles;
		}
		return temp;
	}


	public Roles deleteRol(int id_rol) {
		Roles temp = null;
		for (Roles roles : list) {
			if (roles.getId_rol()== id_rol) {
				temp = roles;
				list.remove(roles);
				break;
			}
		}
		return temp;
	}


	public Roles updateRol(int id_rol, String tipo_rol) {
		Roles temp = null;
		for (Roles roles : list) {
			if (roles.getId_rol()== id_rol) {
				if (tipo_rol.length()!=0) roles.setTipo_rol(tipo_rol);
				temp = roles;
				list.remove(roles);
				break;
			}
		}
		return temp;
	}

}
