package com.huellitas.huellitas.model;

public class Pedidos {
	private int id_pedido;
	private String fechaPedido; //adorno
	private String status;
	private int usuarios_no_usuario; // relación
	private static int total = 0;
	//Constructores
	public Pedidos(String fechaPedido, String status, int usuarios_no_usuario, int id_pedido) {
		super();
		Pedidos.total++;
		id_pedido = Pedidos.total;
		this.fechaPedido = fechaPedido;
		this.status = status;
		this.usuarios_no_usuario = usuarios_no_usuario;
		
	}
	public Pedidos() {
		Pedidos.total++;
		id_pedido = Pedidos.total;
	}
	//Getters y Setters
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public String getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUsuarios_no_usuario() {
		return usuarios_no_usuario;
	}
	public void setUsuarios_no_usuario(int usuarios_no_usuario) {
		this.usuarios_no_usuario = usuarios_no_usuario;
	}
	public static int getTotal() {
		return total;
	}
	public static void setTotal(int total) {
		Pedidos.total = total;
	}
	//toString
	@Override
	public String toString() {
		return "Pedidos [id_pedido=" + id_pedido + ", fechaPedido=" + fechaPedido + ", status=" + status
				+ ", usuarios_no_usuario=" + usuarios_no_usuario + "]";
	}

	
}
