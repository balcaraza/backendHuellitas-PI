package com.huellitas.huellitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//define entidad
@Table(name="productos")//nombre tabla
public class ProductosModel {
	@Id//define como un id en la tabla
	@GeneratedValue (strategy = GenerationType.IDENTITY)///unico y autoincremental
	@Column (name="id", unique = true, nullable = false )
	private Long id_producto;//<-es un long
	@Column(nullable = false )
	private String imagen;
	@Column(nullable = false )
	private String nombreProducto;
	@Column(nullable = false )
	private String descripcion;
	@Column(nullable = false )
	private double precio;
	//private static int total =0;
	//constructor
	public ProductosModel(String imagen, String nombreProducto, String descripcion, double precio) {
		super();
		this.imagen = imagen;
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	//constructor vacio
	public ProductosModel() {

	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Long getId_producto() {
		return id_producto;
	}

	@Override
	public String toString() {
		return "ProductosModel [id_producto=" + id_producto + ", imagen=" + imagen + ", nombreProducto="
				+ nombreProducto + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	
	
	

	}
