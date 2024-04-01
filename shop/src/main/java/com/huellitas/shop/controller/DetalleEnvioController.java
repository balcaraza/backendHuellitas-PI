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

import com.huellitas.shop.model.DetalleEnvio;
import com.huellitas.shop.service.DetalleEnvioService;

@RestController
@RequestMapping(path="/api/DetalleEnvio/") //http://localhost:8080/api/DetalleEnvio/
public class DetalleEnvioController {
	private final DetalleEnvioService detalleEnvioService;
	@Autowired
	public DetalleEnvioController(DetalleEnvioService detalleEnvioService) {
		this.detalleEnvioService = detalleEnvioService;
	}//constructor
	//GET
		@GetMapping
		public List<DetalleEnvio> getDetallesEnvios(){  
			return detalleEnvioService.getAllDetallesEnvios();
			}//getdetalleEnvios
		
	//GET
		@GetMapping(path="{detEnvId}")//http://localhost:8080/api/DetalleEnvio/1
		public DetalleEnvio getDetalleEnvio(@PathVariable("detEnvId") Long detEnvId) {
			return detalleEnvioService.getDetalleEnvio(detEnvId); 
		}//getdetalleEnvio
		
	//POST
		@PostMapping
		public DetalleEnvio addDetalleEnvio(@RequestBody DetalleEnvio detalleEnvio) {
			return detalleEnvioService.addDetalleEnvio(detalleEnvio);
		}//addDetalleEnvio
		
		//DELETE
		@DeleteMapping(path="{detEnvId}")//http://localhost:8080/api/DetalleEnvio/1
		public DetalleEnvio deleteDetalleEnvio(@PathVariable("detEnvId") Long detEnvId) {
			return detalleEnvioService.deleteDetalleEnvio(detEnvId); 
		}//getdetalleEnvio
		
		//PUT
		@PutMapping(path="{detEnvId}")
		public DetalleEnvio updateDetalleEnvio(@PathVariable("detEnvId") Long detEnvId, 
				@RequestBody DetalleEnvio detalleEnvio) {
			return detalleEnvioService.updateDetalleEnvio(detEnvId, detalleEnvio.getNombre_completo(), detalleEnvio.getCalle(),detalleEnvio.getMunicipio(),detalleEnvio.getEstado(),detalleEnvio.getCodigo_postal(),detalleEnvio.getNum_int_ext(),detalleEnvio.getTelefono(),detalleEnvio.getInstrucciones());
		}//updateDetalleEnvio

}
