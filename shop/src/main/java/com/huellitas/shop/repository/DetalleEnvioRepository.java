package com.huellitas.shop.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huellitas.shop.model.DetalleEnvio;

@Repository
public interface DetalleEnvioRepository extends JpaRepository<DetalleEnvio, Long>{
	Optional<DetalleEnvio> findByDetalleEnvioId(Long detEnvId);
}
