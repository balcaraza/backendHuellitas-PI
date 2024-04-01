package com.huellitas.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalle_pedido")
public class DetallePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_detalle_pedido", unique=true, nullable=false)
	private Long id_detalle_pedido;
	@Column(nullable=false)
	private Long cantidad;
	@Column(nullable=false, name="pedidos_id_pedido")
	private Long idPedido; 
	@Column(nullable=false)
	private Long productos_id_productos; 

	private static int total =0;
	//constructores
	

	
	public DetallePedido(Long id_detalle_pedido, Long cantidad, Long idPedido, Long productos_id_productos) {
		super();
		
		this.cantidad = cantidad;
		this.idPedido = idPedido;
		this.productos_id_productos = productos_id_productos;
	}
	
	public DetallePedido() {
		
	}
	//getters y setters
	public Long getId_detalle_pedido() {
		return id_detalle_pedido;
	}

	public void setId_detalle_pedido(Long id_detalle_pedido) {
		this.id_detalle_pedido = id_detalle_pedido;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Long getPedidos_id_pedido() {
		return idPedido;
	}

	public void setPedidos_id_pedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getProductos_id_productos() {
		return productos_id_productos;
	}

	public void setProductos_id_productos(Long productos_id_productos) {
		this.productos_id_productos = productos_id_productos;
	}

	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		DetallePedido.total = total;
	}

//toString
	@Override
	public String toString() {
		return "DetallePedido [id_detalle_pedido=" + id_detalle_pedido + ", cantidad=" + cantidad
				+ ", pedidos_id_pedido=" + idPedido + ", productos_id_productos=" + productos_id_productos
				+ "]";
	}

}
