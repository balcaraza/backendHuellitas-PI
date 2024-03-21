package com.huellitas.huellitas.service;

import java.util.ArrayList;
import com.huellitas.huellitas.model.Pedidos;
import org.springframework.stereotype.Service;

@Service
public class PedidosService {
	public final ArrayList<Pedidos> list = new ArrayList<Pedidos>();

	public PedidosService() {
		list.add( new Pedidos("11123", "enviado", 1));
		list.add( new Pedidos("030124", " en proceso", 2));
	}
	
	public ArrayList<Pedidos> getAllPedidos() {
		return list;
	}

	
	public Pedidos getPedido(int id_pedido) {
		Pedidos tmpPedido = null;
		for (Pedidos pedidos : list) {
			if (pedidos.getId_pedido()==id_pedido) {
				tmpPedido = pedidos;
				break;
			}
		}
		return tmpPedido;
	}

	public Pedidos addPedido(Pedidos pedidos) {
		Pedidos tmpPedido = null;
		if (list.add(pedidos)) {
			tmpPedido=pedidos;
		}
		return tmpPedido;
	}

	public Pedidos deletePedido(int id_pedido) {
		Pedidos tmpPedido = null;		
		for (Pedidos pedidos : list) {
			if (pedidos.getId_pedido()==id_pedido) {
				tmpPedido = pedidos;
				list.remove(pedidos);
				break;
			}
		}
		return tmpPedido;
	}

	public Pedidos updatePedido(int id_pedido, String fechaPedido, String status, Integer usuarios_no_usuario) {
		Pedidos tmpPedido = null;	
		for (Pedidos pedidos : list) {
			if (pedidos.getId_pedido()==id_pedido) {
				if (fechaPedido.length()!=0) pedidos.setFechaPedido(fechaPedido);
				if (status.length()!=0) pedidos.setStatus(status);
				if (usuarios_no_usuario.intValue()<=0) pedidos.setUsuarios_no_usuario(usuarios_no_usuario);
				tmpPedido = pedidos;
				break;
			}
		}
		return tmpPedido;
	}
	
	

}//PedidosService
