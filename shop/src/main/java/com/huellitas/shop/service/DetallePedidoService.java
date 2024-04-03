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

	public DetallePedido getDetallePedido(Long id_detalle_pedido) {
		return detallePedidoRepository.findById(id_detalle_pedido).orElseThrow(
				()->new IllegalArgumentException("El detalle de pedido con el id ["
						+ id_detalle_pedido + "] no existe"));
	}

	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		List<DetallePedido>tmpDetallePedido=detallePedidoRepository.findByIdPedido(detallePedido.getIdPedido());
		if(tmpDetallePedido.size()==0) {
			return detallePedidoRepository.save(detallePedido);
		}else {
			System.out.println("ya existe un detalle pedido con el ["
					+ detallePedido.getIdPedido()+"]");	
		}
		return null;
	}

	public DetallePedido deleteDetallePedido(Long id_detalle_pedido) {
		DetallePedido tmpDetallePedido = null;
		if (detallePedidoRepository.existsById(id_detalle_pedido)) {
			tmpDetallePedido=detallePedidoRepository.findById(id_detalle_pedido).get();
			detallePedidoRepository.deleteById(id_detalle_pedido);
		}
		return tmpDetallePedido;
	}

	public DetallePedido updateDetallePedido(Long id_detalle_pedido, Long cantidad, Long pedidos_id_pedido,Long productos_id_productos) {
		
		DetallePedido tmpDetallePedido = null;
		
			if(detallePedidoRepository.existsById(id_detalle_pedido)) {
				tmpDetallePedido =detallePedidoRepository.findById(id_detalle_pedido).get();
				if(cantidad!=null) tmpDetallePedido.setCantidad(cantidad);
				if(pedidos_id_pedido!=null) tmpDetallePedido.setIdPedido(pedidos_id_pedido);;
				if(productos_id_productos>0) tmpDetallePedido.setProductos_id_productos(pedidos_id_pedido);
				detallePedidoRepository.save(tmpDetallePedido);
			}
		return tmpDetallePedido;
	}


}
