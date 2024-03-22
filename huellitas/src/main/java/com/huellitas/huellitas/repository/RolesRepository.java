package com.huellitas.huellitas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huellitas.huellitas.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>  {
	Optional<Roles> findByTipoRol (String name);
}
