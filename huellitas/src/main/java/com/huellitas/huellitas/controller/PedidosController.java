package com.huellitas.huellitas.controller;

import java.util.List;

import com.huellitas.huellitas.model.Pedidos;
import com.huellitas.huellitas.service.PedidosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/pedidos/")

public class PedidosController {
	private final PedidosService pedidosService;

	@Autowired
	public PedidosController(PedidosService pedidosService) {
		this.pedidosService = pedidosService;
	}
	
	@GetMapping
	public List<Pedidos> getPedidos() {
		return pedidosService.getAllPedidos();
	}
	
	@GetMapping (path="{id_pedido}")
	public Pedidos getPedido (@PathVariable("id_pedido") Long id_pedido) {
		return pedidosService.getPedido(id_pedido);
	}
	
	@PostMapping
	public Pedidos addPedido (@RequestBody Pedidos pedidos) {
		return pedidosService.addPedido(pedidos);
	}

	@DeleteMapping (path="{id_pedido}")
	public Pedidos deletePedido (@PathVariable("id_pedido") Long id_pedido) {
		return pedidosService.deletePedido(id_pedido);
	}

	@PutMapping(path="{id_pedido}")//http://localhost:8080/api/pedidos/()
	public Pedidos updatePedido(@PathVariable("id_pedido")Long id_pedido, 
			@RequestBody Pedidos pedidos) {
		return pedidosService.updatePedido(id_pedido, pedidos.getFechaPedido(),pedidos.getStatus(), pedidos.getUsuarios_no_usuario());
	}

}//PedidosController
