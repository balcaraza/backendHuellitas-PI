package com.huellitas.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huellitas.shop.service.DetallePedidoService;
import com.huellitas.shop.model.DetallePedido;

@RestController
@RequestMapping(path="/api/detallePedido/")//http://localhost:8080/api/detallePedido/
public class DetallePedidoController {
	private final DetallePedidoService detallePedidoService;
	@Autowired
	public DetallePedidoController(DetallePedidoService detallePedidoService) {
		this.detallePedidoService=detallePedidoService;
	}//constructor

	@GetMapping
	public List<DetallePedido>getDetallesPedidos(){
		return detallePedidoService.getAllDetallesPedidos();
	}
	//get (detallePedidoId)
	@GetMapping (path="{id_detalle_pedido}")//http://localhost:8080/api/detallePedido/1
	public DetallePedido getDetallePedido(@PathVariable("id_detalle_pedido") Long id_detalle_pedido) {
		return detallePedidoService.getDetallePedido(id_detalle_pedido);
	}
	//post
	@PostMapping
	public DetallePedido addDetallePedido(@RequestBody DetallePedido detallePedido) {
		return detallePedidoService.addDetallePedido(detallePedido);
	}
	//delete
	@DeleteMapping(path="{id_detalle_pedido}")//http://localhost:8080/api/detallePedido/1
	public DetallePedido deleteDetallePedido(@PathVariable("id_detalle_pedido") Long id_detalle_pedido) {
		return detallePedidoService.deleteDetallePedido(id_detalle_pedido);
	}
	//put
	@PutMapping(path="{id_detalle_pedido}")//http://localhost:8080/api/pedidos/
	public DetallePedido updateDetallePedido(@PathVariable("id_detalle_pedido")Long id_detalle_pedido, 
			@RequestBody DetallePedido detallePedido) {
		return detallePedidoService.updateDetallePedido(id_detalle_pedido, 
				detallePedido.getCantidad(), detallePedido.getIdPedido(),
				detallePedido.getProductos_id_productos());
	}//
}
