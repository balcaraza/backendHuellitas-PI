package com.huellitas.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huellitas.shop.model.DetallePedido;
import com.huellitas.shop.repository.DetallePedidoRepository;

@Service
public class DetallePedidoService {
public final DetallePedidoRepository detallePedidoRepository;
	
	@Autowired
	public DetallePedidoService(DetallePedidoRepository detallePedidoRepository) {
		this.detallePedidoRepository=detallePedidoRepository;
	}

	public List<DetallePedido> getAllDetallesPedidos() {
		return detallePedidoRepository.findAll();
	}

	public DetallePedido getDetallePedido(Long detallePedidoId) {
		return detallePedidoRepository.findById(detallePedidoId).orElseThrow(
				()->new IllegalArgumentException("El detalle de pedido con el id ["
						+ "] no xiste"));
		
	}

	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		Optional<List<DetallePedido>>tmpDetallePedido=detallePedidoRepository.findByIdPedido(detallePedido.getPedidos_id_pedido());
		if(tmpDetallePedido.isEmpty()) {
			return detallePedidoRepository.save(detallePedido);
		}else {
			System.out.println("ya existe un detalle pedido con el ["
					+ detallePedido.getPedidos_id_pedido()+"]");
			return null;
		}
	}

	public DetallePedido deleteDetallePedido(Long detallePedidoId) {
		DetallePedido tmpDetallePedido = null;
		if (detallePedidoRepository.existsById(detallePedidoId)) {
			tmpDetallePedido=detallePedidoRepository.findById(detallePedidoId).get();
			detallePedidoRepository.deleteById(detallePedidoId);
		}
		return tmpDetallePedido;
	}

	public DetallePedido updateDetallePedido(Long detallePedidoId, Long cantidad, Long pedidos_id_pedido,Long productos_id_productos) {
		
		DetallePedido tmpDetallePedido = null;
		
			if(detallePedidoRepository.existsById(detallePedidoId)) {
				
				tmpDetallePedido =detallePedidoRepository.findById(detallePedidoId).get();
				if(cantidad!=null) tmpDetallePedido.setCantidad(cantidad);
				if(pedidos_id_pedido!=null) tmpDetallePedido.setPedidos_id_pedido(pedidos_id_pedido);;
				if(productos_id_productos>0) tmpDetallePedido.setProductos_id_productos(pedidos_id_pedido);
				detallePedidoRepository.save(tmpDetallePedido);
			}
		
		return tmpDetallePedido;
	}


}
