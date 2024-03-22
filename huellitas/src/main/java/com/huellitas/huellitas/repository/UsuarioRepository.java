package com.huellitas.huellitas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.huellitas.huellitas.model.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{
    Optional<Usuarios> findByCorreo(String correo);
}//interface UsuarioRepository
