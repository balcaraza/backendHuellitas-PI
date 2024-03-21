package com.huellitas.huellitas.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.huellitas.huellitas.model.DetalleEnvio;

@Service
public class DetalleEnvioService {
	public final ArrayList<DetalleEnvio> list = new ArrayList<DetalleEnvio>();
	
	public DetalleEnvioService(){
  		list.add(new DetalleEnvio("Amparo Sonia Garibay ortiz", "Gonzalez Ortega", "Tlajomjulco de Zuñiga", "Jalisco", "45650", "145A", "79605462", "Entregar frente la puerta de barrotes"));
		list.add(new DetalleEnvio("Balam Alcaraz", "Nilo", "Azcapotzalco", "Ciudad de México", "02080", "117", "5588062943", "Zaguan negro"));
		list.add(new DetalleEnvio("Juan Perez Cruz", "'Canal de la Sangría", "Tláhuac", "Ciudad de México", "13529", "041", "5575265435", "Zaguán negro al lado de una Papeleria"));
		list.add(new DetalleEnvio("Fulanito Desconocido", "Sanchez Colín", "Ecatepec", "Estado de México", "55339", "22-44", "5633809918", "casa azul, zaguan rústico"));
		list.add(new DetalleEnvio("Hugo Castaneda Hernandez", "Progreso", "Ecatepec", "Estado de México", "55270", "33-44", "5583429615", "casa negra"));
	
		}//constructor	

	public  ArrayList<DetalleEnvio> getAllDetalleEnvios() {
		return list;
	}//getAllDetalleEnvio

	public DetalleEnvio getDetalleEnvio(int detEnvId) {
		DetalleEnvio tmpDetEnv=null;
		for (DetalleEnvio detalleEnvio : list) {
			if(detalleEnvio.getId_detalle_compra()==detEnvId) {
				tmpDetEnv=detalleEnvio; 
				break;				
			}//if==
		}//foreach		
		return  tmpDetEnv;
	}//getDetalleEnvio

	public  DetalleEnvio addDetalleEnvio(DetalleEnvio detalleEnvio) {
		DetalleEnvio tmpDetEnv=null;
		if(list.add(detalleEnvio)) {
			tmpDetEnv=detalleEnvio;
		}//if		
		return tmpDetEnv;
	}//addDetalleEnvio

	public DetalleEnvio deleteDetalleEnvio(int detEnvId) {
		DetalleEnvio tmpDetEnv=null;
		for (DetalleEnvio detalleEnvio : list) {
			if(detalleEnvio.getId_detalle_compra()==detEnvId) {
				tmpDetEnv=detalleEnvio; 
				list.remove(detalleEnvio);
				break;				
			}//if==
		}//foreach		
		return  tmpDetEnv;
	}//deleteDetalleEnvio

	public DetalleEnvio updateDetalleEnvio(int detEnvId, String nombre_completo, String calle, String municipio,
			String estado, String codigo_postal, String num_int_ext, String telefono, String instrucciones) {
		DetalleEnvio tmpDetEnv=null;
		for (DetalleEnvio detalleEnvio : list) {
			if(detalleEnvio.getId_detalle_compra()==detEnvId) {
				if(nombre_completo!=null) detalleEnvio.setNombre_completo(nombre_completo);
				if(calle!=null) detalleEnvio.setCalle(calle);
				if(municipio!=null) detalleEnvio.setMunicipio(municipio);
				if(estado!=null) detalleEnvio.setEstado(estado);
				if(codigo_postal!=null) detalleEnvio.setCodigo_postal(codigo_postal);
				if(num_int_ext!=null) detalleEnvio.setNum_int_ext(num_int_ext);
				if(telefono!=null) detalleEnvio.setTelefono(telefono);
				if(instrucciones!=null) detalleEnvio.setInstrucciones(instrucciones);
				tmpDetEnv=detalleEnvio; 
				break;				
			}//if==
		}//foreach		
		return  tmpDetEnv;
	}//updateDetalleEnvio
	
}//class DetalleEnvioService
