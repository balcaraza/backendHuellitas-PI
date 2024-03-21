package com.huellitas.huellitas.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huellitas.huellitas.model.DetallePedido;
import com.huellitas.huellitas.service.DetallePedidoService;

@RestController
@RequestMapping(path="/api/detallePedido/")//http://localhost:8080/api/detallePedido/
public class DetallePedidoController {
	
	private final DetallePedidoService detallePedidoService;
	@Autowired
	public DetallePedidoController(DetallePedidoService detallePedidoService) {
		this.detallePedidoService=detallePedidoService;
	}//constructor

	@GetMapping
	public ArrayList<DetallePedido>getDetallesPedidos(){
		return detallePedidoService.getAllDetallesPedidos();
	}
	//get
	@GetMapping (path="{detallePedidoId}")//http://localhost:8080/api/detallePedido/1
	public DetallePedido getDetallePedido(@PathVariable("detallePedidoId") int detallePedidoId) {
		return detallePedidoService.getDetallePedido(detallePedidoId);
	}
	//post
	@PostMapping
	public DetallePedido addDetallePedido(@RequestBody DetallePedido detallePedido) {
		return detallePedidoService.addDetallePedido(detallePedido);
	}
	//delete
	@DeleteMapping(path="{detallePedidoId}")//http://localhost:8080/api/detallePedido/1
	public DetallePedido DetallePedido(@PathVariable("detallePedidoId") int detallePedidoId) {
		return detallePedidoService.deleteDetallePedido(detallePedidoId);
	}
	//put
	@PutMapping(path="{detallePedidoId}")//http://localhost:8080/api/pedidos/
	public DetallePedido updateDetallePedido(@PathVariable("detallePedidoId")int detallePedidoId, 
			@RequestBody DetallePedido detallePedido) {
		return detallePedidoService.updateDetallePedido(detallePedidoId, 
				detallePedido.getFechaPedido(), detallePedido.getUsuario(),
				Integer.valueOf(detallePedido.getUsuarios_no_usuarios()));
	}//
	
}



