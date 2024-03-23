package com.huellitas.huellitas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huellitas.huellitas.model.DetalleTarjeta;

@Repository
public interface DetalleTarjetaRepository extends JpaRepository<DetalleTarjeta, Long>{
	Optional<DetalleTarjeta> findByNumeroTarjeta(String numeroTarjeta);
	Optional<DetalleTarjeta> findByNombreTarjeta(String nombreTarjeta);
	Optional<DetalleTarjeta> findByNumeroTarjetaAndNombreTarjeta(String numeroTarjeta, String nombreTarjeta);
	
}
