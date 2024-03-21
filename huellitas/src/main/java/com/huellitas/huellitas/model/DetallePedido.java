package com.huellitas.huellitas.model;

public class DetallePedido {
	private int id_pedido;
	private String fechaPedido;
	private String usuario; 
	private int usuarios_no_usuarios; 

	private static int total =0;
	//constructores
	

	public DetallePedido( String fechaPedido, String usuario, int usuarios_no_usuarios) {
		super();
		DetallePedido.total++;
		id_pedido = DetallePedido.total;
		this.fechaPedido = fechaPedido;
		this.usuario = usuario;
		this.usuarios_no_usuarios = usuarios_no_usuarios;
	}
	public DetallePedido() {
		DetallePedido.total++;
		id_pedido = DetallePedido.total;
	}
	//getters y setters
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getUsuarios_no_usuarios() {
		return usuarios_no_usuarios;
	}
	public void setUsuarios_no_usuarios(int usuarios_no_usuarios) {
		this.usuarios_no_usuarios = usuarios_no_usuarios;
	}
	public static int getTotal() {
		return total;
	}
	public static void setTotal(int total) {
		DetallePedido.total = total;
	}
	@Override
	public String toString() {
		return "DetallePedido [id_pedido=" + id_pedido + ", fechaPedido=" + fechaPedido + ", usuario=" + usuario
				+ ", usuarios_no_usuarios=" + usuarios_no_usuarios + "]";
	}
	
	//toString
	
	
	
}
