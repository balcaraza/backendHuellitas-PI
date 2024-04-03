package com.huellitas.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huellitas.shop.model.ProductosModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductosModel, Long>{
	Optional<ProductosModel> findByNombreProducto(String nombreProducto);
}
