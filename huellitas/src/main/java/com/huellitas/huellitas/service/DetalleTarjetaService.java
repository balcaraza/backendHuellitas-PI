package com.huellitas.huellitas.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.huellitas.huellitas.model.DetalleTarjeta;

@Service
public class DetalleTarjetaService {
	public final ArrayList<DetalleTarjeta> listaDetalleTarjetas = new ArrayList<DetalleTarjeta>();
	
	public DetalleTarjetaService() {
		listaDetalleTarjetas.add(new DetalleTarjeta("Juan Peréz Orosco", "1679345091234581", 07, 2027, "406"));
		listaDetalleTarjetas.add(new DetalleTarjeta("Rosa de la Costa", "6340286412006457", 12, 2025, "106"));
		listaDetalleTarjetas.add(new DetalleTarjeta("Felipe Castañeda", "4790130413704583", 03, 2030, "900"));
	}//Constructor vacio

	public ArrayList<DetalleTarjeta> getAllDetalleTarjetas() {
		return listaDetalleTarjetas;
	}//getAllDetalleTarjetas

	public DetalleTarjeta getDetalleTarjeta(int tarjetaId) {
		DetalleTarjeta deTarjeta = null;
		for (DetalleTarjeta detalleTarjeta : listaDetalleTarjetas) {
			if(detalleTarjeta.getId_pago() == tarjetaId) {
				deTarjeta = detalleTarjeta;
				break;
			}
		}
		return deTarjeta;
	}//getDetalleTarjeta

	public DetalleTarjeta addDetalleTarjeta(DetalleTarjeta detalleTarjeta) {
		DetalleTarjeta deTarjeta = null;
		if(listaDetalleTarjetas.add(detalleTarjeta)) {
			deTarjeta = detalleTarjeta;
		}
		return deTarjeta;
	}//addDetalleTarjeta

	public DetalleTarjeta updateDetalleTarjeta(int tarjetaId, String nombre_tarjeta, String no_tarjeta, int mes,
			int anio, String codigo_seguridad) {
		DetalleTarjeta deTarjeta = null;
		for (DetalleTarjeta detalleTarjeta : listaDetalleTarjetas) {
			if(detalleTarjeta.getId_pago() == tarjetaId) {
				deTarjeta = detalleTarjeta;
				if(nombre_tarjeta.length() != 0) detalleTarjeta.setNombre_tarjeta(nombre_tarjeta);
				if(no_tarjeta.length() != 0) detalleTarjeta.setNo_tarjeta(no_tarjeta);
				if(codigo_seguridad.length() != 0) detalleTarjeta.setCodigo_seguridad(codigo_seguridad);
				if(mes > 0) detalleTarjeta.setMes(mes);
				if(anio > 0) detalleTarjeta.setAnio(anio);
			}
		}
		return deTarjeta;
	}//updateDetalleTarjeta

	public DetalleTarjeta deleteDetalleTarjeta(int tarjetaId) {
		DetalleTarjeta deTarjeta = null;
		for (DetalleTarjeta detalleTarjeta : listaDetalleTarjetas) {
			if(detalleTarjeta.getId_pago() == tarjetaId) {
				deTarjeta = detalleTarjeta;
				listaDetalleTarjetas.remove(detalleTarjeta);
				break;
			}
		}
		return deTarjeta;
	}//deleteDetalleTarjeta
	
}//class DetalleTarjetaService
