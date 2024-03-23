package com.huellitas.huellitas.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huellitas.huellitas.model.DetalleEnvio;
import com.huellitas.huellitas.repository.DetalleEnvioRepository;

@Service
public class DetalleEnvioService {
	
	public final DetalleEnvioRepository detalleEnvioRepository;
	
	@Autowired
	public  DetalleEnvioService(DetalleEnvioRepository detalleEnvioRepository) {
		this.detalleEnvioRepository=detalleEnvioRepository;
		}//constructor


	public  List<DetalleEnvio> getAllDetallesEnvios() {
		return detalleEnvioRepository.findAll();
	}//getAllDetalleEnvio

	public DetalleEnvio getDetalleEnvio(Long detEnvId) {
		return detalleEnvioRepository.findById(detEnvId).orElseThrow(
				()->new IllegalArgumentException("El detalle de envío con id ["+
						detEnvId + "] no existe")
				);
	}//getDetalleEnvio

	public  DetalleEnvio addDetalleEnvio(DetalleEnvio detalleEnvio) {
		DetalleEnvio tmpDetEnv=null;	
		tmpDetEnv = detalleEnvioRepository.save(detalleEnvio);
		return tmpDetEnv;
	}//addDetalleEnvio

	public DetalleEnvio deleteDetalleEnvio(Long detEnvId) {
		DetalleEnvio tmpDetEnv=null;
		if(detalleEnvioRepository.existsById(detEnvId)) {
			tmpDetEnv=detalleEnvioRepository.findById(detEnvId).get();
			detalleEnvioRepository.deleteById(detEnvId);
		}//if
		return  tmpDetEnv;
	}//deleteDetalleEnvio

	public DetalleEnvio updateDetalleEnvio(Long detEnvId, String nombre_completo, String calle, String municipio,
			String estado, String codigo_postal, String num_int_ext, String telefono, String instrucciones) {
		DetalleEnvio detalleEnvio=null;
		if(detalleEnvioRepository.existsById(detEnvId)) {
			detalleEnvio=detalleEnvioRepository.findById(detEnvId).get();
				if(nombre_completo!=null) detalleEnvio.setNombre_completo(nombre_completo);
				if(calle!=null) detalleEnvio.setCalle(calle);
				if(municipio!=null) detalleEnvio.setMunicipio(municipio);
				if(estado!=null) detalleEnvio.setEstado(estado);
				if(codigo_postal!=null) detalleEnvio.setCodigo_postal(codigo_postal);
				if(num_int_ext!=null) detalleEnvio.setNum_int_ext(num_int_ext);
				if(telefono!=null) detalleEnvio.setTelefono(telefono);
				if(instrucciones!=null) detalleEnvio.setInstrucciones(instrucciones);	
				detalleEnvioRepository.save(detalleEnvio);
		}//exist	
		return  detalleEnvio;
	}//updateDetalleEnvio
	
}//class DetalleEnvioService
