package com.huellitas.huellitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huellitas.huellitas.model.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long>{

}
