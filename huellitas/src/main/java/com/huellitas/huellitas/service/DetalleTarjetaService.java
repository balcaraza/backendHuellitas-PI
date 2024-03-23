package com.huellitas.huellitas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huellitas.huellitas.model.DetalleTarjeta;
import com.huellitas.huellitas.repository.DetalleTarjetaRepository;

@Service
public class DetalleTarjetaService {
	
	private final DetalleTarjetaRepository detalleTarjetaRepository;
	
	@Autowired
	public DetalleTarjetaService(DetalleTarjetaRepository detalleTarjetaRepository) {
		this.detalleTarjetaRepository = detalleTarjetaRepository;
	}//Constructor vacio

	public List<DetalleTarjeta> getAllDetalleTarjetas() {
		return detalleTarjetaRepository.findAll();
	}//getAllDetalleTarjetas

	public DetalleTarjeta getDetalleTarjeta(long tarjetaId) {
		return detalleTarjetaRepository.findById(tarjetaId).orElseThrow(
				()->new IllegalArgumentException("El producto con el id [" +
						tarjetaId + "] no existe")
				);
	}//getDetalleTarjeta

	public DetalleTarjeta addDetalleTarjeta(DetalleTarjeta detalleTarjeta) {
		//Optional<DetalleTarjeta> numeroTarjeta = detalleTarjetaRepository.findByNumeroTarjeta(detalleTarjeta.getNo_tarjeta());
		//Optional<DetalleTarjeta> nombreTarjeta = detalleTarjetaRepository.findByNombreTarjeta(detalleTarjeta.getNombre_tarjeta());
		
		Optional<DetalleTarjeta> existeDetalleTarjeta = detalleTarjetaRepository.findByNumeroTarjetaAndNombreTarjeta(detalleTarjeta.getNo_tarjeta(), detalleTarjeta.getNombre_tarjeta());
		
	    // Verifica cada uno de los campos obligatorios y asegúrate de que no estén vacíos
	    if (detalleTarjeta.getNombre_tarjeta() == null || detalleTarjeta.getNombre_tarjeta().isEmpty() ||
	        detalleTarjeta.getNo_tarjeta() == null || detalleTarjeta.getNo_tarjeta().isEmpty() ||
	        detalleTarjeta.getCodigo_seguridad() == null || detalleTarjeta.getCodigo_seguridad().isEmpty()) {
	        throw new IllegalArgumentException("Algunos campos obligatorios están vacíos");
	    }

	    if (existeDetalleTarjeta.isPresent()) {
	        throw new IllegalArgumentException("Este número de tarjeta ya ha sido registrado para este usuario");
	    }
	    
	    // Si todos los campos obligatorios tienen valores, guarda el objeto en la base de datos
	    return detalleTarjetaRepository.save(detalleTarjeta);
	}//addDetalleTarjeta

	public DetalleTarjeta updateDetalleTarjeta(Long tarjetaId, String nombre_tarjeta, String no_tarjeta, int mes,
			int anio, String codigo_seguridad) {
		DetalleTarjeta deTarjeta = null;
			if(detalleTarjetaRepository.existsById(tarjetaId)) {
				deTarjeta = detalleTarjetaRepository.findById(tarjetaId).get();
				if(nombre_tarjeta.length() != 0) deTarjeta.setNombre_tarjeta(nombre_tarjeta);
				if(no_tarjeta.length() != 0) deTarjeta.setNo_tarjeta(no_tarjeta);
				if(codigo_seguridad.length() != 0) deTarjeta.setCodigo_seguridad(codigo_seguridad);
				if(mes > 0) deTarjeta.setMes(mes);
				if(anio > 0) deTarjeta.setAnio(anio);
				detalleTarjetaRepository.save(deTarjeta);
			}//if existsById
		return deTarjeta;
	}//updateDetalleTarjeta

	public DetalleTarjeta deleteDetalleTarjeta(Long tarjetaId) {
		DetalleTarjeta deTarjeta = null;
		if(detalleTarjetaRepository.existsById(tarjetaId)) {
			deTarjeta = detalleTarjetaRepository.findById(Long.valueOf(tarjetaId)).get();
			detalleTarjetaRepository.deleteById(Long.valueOf(tarjetaId));
		}//if
		return deTarjeta;
	}//deleteDetalleTarjeta
	
}//class DetalleTarjetaService
