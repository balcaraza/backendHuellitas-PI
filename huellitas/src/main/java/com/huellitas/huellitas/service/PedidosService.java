package com.huellitas.huellitas.service;

import java.util.List;
import java.util.Optional;

import com.huellitas.huellitas.model.Pedidos;
import com.huellitas.huellitas.repository.PedidosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidosService {
	public final PedidosRepository pedidosRepository;

	@Autowired
	public PedidosService(PedidosRepository pedidosRepository) {
		this.pedidosRepository = pedidosRepository;
	}
	
	public List<Pedidos> getAllPedidos() {
		return pedidosRepository.findAll();
	}

	public Pedidos getPedido(Long id_pedido) {
		return pedidosRepository.findById(id_pedido).orElseThrow(
				()-> new IllegalArgumentException("No existe un pedido con id "+ id_pedido));
	}

	public Pedidos addPedido(Pedidos pedidos) {
			return pedidosRepository.save(pedidos);
	}

	public Pedidos deletePedido(Long id_pedido) {
		Pedidos tmpPedido = null;		
		if(pedidosRepository.existsById(id_pedido)) {
			tmpPedido = pedidosRepository.findById(Long.valueOf(id_pedido)).get();
			pedidosRepository.deleteById(Long.valueOf(id_pedido));
		}
	return tmpPedido;
	}
	
	public Pedidos updatePedido(Long id_pedido, String fechaPedido, String status, Integer usuarios_no_usuario) {
	Pedidos pedidos = null;
	if(pedidosRepository.existsById(id_pedido)) {
		pedidos = pedidosRepository.findById(id_pedido).get();
			if (fechaPedido.length()!=0) pedidos.setFechaPedido(fechaPedido);
			if (status.length()!=0) pedidos.setStatus(status);
			if (usuarios_no_usuario!= null) pedidos.setUsuarios_no_usuario(usuarios_no_usuario);
			pedidosRepository.save(pedidos);
	}//exists
	return pedidos;
}//updateUser

}//PedidosService
