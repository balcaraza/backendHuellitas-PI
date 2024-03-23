package com.huellitas.huellitas.controller;

import java.util.ArrayList;
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

import com.huellitas.huellitas.model.DetalleTarjeta;
import com.huellitas.huellitas.service.DetalleTarjetaService;

@RestController
@RequestMapping(path="/api/tarjetas/")
public class DetalleTarjetaController {
	
	//Nos va a syudar a vincularnos con el servicio
	private final DetalleTarjetaService detalleTarjetaService;
	
	//Constructor para inicializarlo
	@Autowired
	public DetalleTarjetaController(DetalleTarjetaService detalleTarjetaService) {
		this.detalleTarjetaService = detalleTarjetaService;
	}
	
	//Get
	@GetMapping
	public List<DetalleTarjeta> getDetalleTarjetas(){
		return detalleTarjetaService.getAllDetalleTarjetas();
	}//getDetalleTarjetas
	
	@GetMapping(path = "{tarjetaId}")
	public DetalleTarjeta getDetalleTarjeta(@PathVariable("tarjetaId") int tarjetaId) {
		return detalleTarjetaService.getDetalleTarjeta(tarjetaId);
	}//getDetalleTarjeta
	
	//Post
	@PostMapping
	public DetalleTarjeta addDetalleTarjeta(@RequestBody DetalleTarjeta detalleTarjeta) {
		return detalleTarjetaService.addDetalleTarjeta(detalleTarjeta);
	}//addDetalleTarjeta
	
	//Put
	@PutMapping(path="{tarjetaId}")
	public DetalleTarjeta updateDetalleTarjeta(@PathVariable("tarjetaId") Long tarjetaId, 
			@RequestBody DetalleTarjeta detalleTarjeta) {
		return detalleTarjetaService.updateDetalleTarjeta(tarjetaId, detalleTarjeta.getNombre_tarjeta(),
				detalleTarjeta.getNo_tarjeta(), detalleTarjeta.getMes(), detalleTarjeta.getAnio(),
				detalleTarjeta.getCodigo_seguridad());
	}
	
	//Delete
	@DeleteMapping(path="{tarjetaId}")
	public DetalleTarjeta deleteDetalleTarjeta(@PathVariable("tarjetaId") Long tarjetaId) {
		return detalleTarjetaService.deleteDetalleTarjeta(tarjetaId);
	}
	
	
}//class DetallePedidoController
