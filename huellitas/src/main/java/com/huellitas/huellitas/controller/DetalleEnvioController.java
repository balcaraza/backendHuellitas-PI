package com.huellitas.huellitas.controller;
import com.huellitas.huellitas.model.DetalleEnvio;

 
import java.util.List;

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

import com.huellitas.huellitas.service.DetalleEnvioService;

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
				@RequestParam (required=false)String nombre_completo,
				@RequestParam (required=false)String calle,
				@RequestParam (required=false)String municipio,
				@RequestParam (required=false)String estado,
				@RequestParam (required=false)String codigo_postal,
				@RequestParam (required=false)String num_int_ext,
				@RequestParam (required=false)String telefono,
				@RequestParam (required=false)String instrucciones) {
			
			return detalleEnvioService.updateDetalleEnvio(detEnvId, nombre_completo, calle, municipio, estado, codigo_postal, num_int_ext,telefono, instrucciones );
		}//updateDetalleEnvio

}//class DetalleEnvioController
