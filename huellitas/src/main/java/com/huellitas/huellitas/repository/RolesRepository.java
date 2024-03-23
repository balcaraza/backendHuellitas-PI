package com.huellitas.huellitas.repository;

import java.util.Optional;

import com.huellitas.huellitas.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>  {
	Optional<Roles> findByTipo_rol(String tipo_rol);
}
