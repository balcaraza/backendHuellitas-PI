package com.huellitas.huellitas.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.huellitas.huellitas.model.DetallePedido;

@Service
public class DetallePedidoService {
	public final ArrayList<DetallePedido> list = new ArrayList<DetallePedido>();
	
	public DetallePedidoService() {
		list.add(new DetallePedido("20/03/2024","enviado",4));
		list.add(new DetallePedido("20/03/2024","en embarque",5));
		list.add(new DetallePedido("20/03/2024","recibido",6));
		
	}

	public ArrayList<DetallePedido> getAllDetallesPedidos() {
		// TODO Auto-generated method stub
		return list;
	}

	public DetallePedido getDetallePedido(int detallePedidoId) {
		DetallePedido tmpDetallePedido= null;
		for (DetallePedido detallePedido : list) {
			if(detallePedido.getId_pedido()==detallePedidoId) {
				tmpDetallePedido=detallePedido;
				break;
			}
		}
		return tmpDetallePedido;
	}

	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		DetallePedido tmpDetallePedido = null;
		if(list.add(tmpDetallePedido)) {
			tmpDetallePedido=detallePedido;
		}
		return tmpDetallePedido;
	}

	public DetallePedido deleteDetallePedido(int detallePedidoId) {
		DetallePedido tmpDetallePedido = null;
		for (DetallePedido detallePedido : list) {
			if(detallePedido.getId_pedido()==detallePedidoId) {
				tmpDetallePedido=detallePedido;
				list.remove(tmpDetallePedido);
				break;
			}
		}
		return tmpDetallePedido;
	}

	public DetallePedido updateDetallePedido(int detallePedidoId, String fechaPedido, String usuario,
			Integer usuarios_no_usuarios) {
		DetallePedido tmpDetallePedido = null;
		for (DetallePedido detallePedido : list) {
			if(detallePedido.getId_pedido()==detallePedidoId) {
				if(fechaPedido!=null) detallePedido.setFechaPedido(fechaPedido);
				if(usuario!=null) detallePedido.setUsuario(usuario);;
				if(usuarios_no_usuarios.intValue()>0) detallePedido.setUsuarios_no_usuarios(detallePedidoId);;
				tmpDetallePedido=detallePedido;
				break;
			}
		}
		return tmpDetallePedido;
	}


	

	
	
}
