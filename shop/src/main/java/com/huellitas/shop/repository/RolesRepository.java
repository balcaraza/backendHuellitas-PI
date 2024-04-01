package com.huellitas.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huellitas.shop.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long>  {
	Optional<Roles> findByTipoRol(String tipoRol);
}

