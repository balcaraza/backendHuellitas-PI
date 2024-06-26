package com.huellitas.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huellitas.shop.model.DetalleEnvio;
import com.huellitas.shop.repository.DetalleEnvioRepository;

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
			if(nombre_completo.length()!=0) detalleEnvio.setNombre_completo(nombre_completo);
			if(calle.length()!=0) detalleEnvio.setCalle(calle);
			if(municipio.length()!=0) detalleEnvio.setMunicipio(municipio);
			if(estado.length()!=0) detalleEnvio.setEstado(estado);
			if(codigo_postal.length()!=0) detalleEnvio.setCodigo_postal(codigo_postal);
			if(num_int_ext.length()!=0) detalleEnvio.setNum_int_ext(num_int_ext);
			if(telefono.length()!=0) detalleEnvio.setTelefono(telefono);
			if(instrucciones.length()!=0) detalleEnvio.setInstrucciones(instrucciones);
				detalleEnvioRepository.save(detalleEnvio);
		}//exist	
		return  detalleEnvio;
	}//updateDetalleEnvio
}
