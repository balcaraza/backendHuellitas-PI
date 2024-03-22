package com.huellitas.huellitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="pedidos")
public class Pedidos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id_pedido;
	@Column(nullable=false)
	private String fechaPedido; //adorno
	@Column(nullable=false)
	private String status;
	@Column(nullable=false)
	private int usuarios_no_usuario; // relación
	//Constructores
	public Pedidos(String fechaPedido, String status, int usuarios_no_usuario) {
		super();
		this.fechaPedido = fechaPedido;
		this.status = status;
		this.usuarios_no_usuario = usuarios_no_usuario;
	}
	public Pedidos() {}
	//Getters y Setters
	public Long getId_pedido() {
		return id_pedido;
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
	//toString
	@Override
	public String toString() {
		return "Pedidos [id_pedido=" + id_pedido + ", fechaPedido=" + fechaPedido + ", status=" + status
				+ ", usuarios_no_usuario=" + usuarios_no_usuario + "]";
	}
}
