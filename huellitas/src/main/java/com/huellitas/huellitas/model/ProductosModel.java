package com.huellitas.huellitas.model;

public class ProductosModel {
	private int id_producto;
	private String imagen;
	private String nombre_producto;
	private String descripcion;
	private double precio;
	private static int total =0;
	//contructor
	public ProductosModel(String imagen, String nombre_producto, String descripcion, double precio) {
		super();
		
		this.imagen = imagen;
		this.nombre_producto = nombre_producto;
		this.descripcion = descripcion;
		this.precio = precio;
		ProductosModel.total++;
		id_producto=ProductosModel.total;
	}
	//constructor vacio
	public ProductosModel() {
		ProductosModel.total++;
		id_producto=ProductosModel.total;
	}
	//getters y setters
	public int getId_producto() {
		return id_producto;
	}
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
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
	public static int getTotal() {
		return total;
	}
	public static void setTotal(int total) {
		ProductosModel.total = total;
	}
	
	//to string
		@Override
		public String toString() {
			return "ProductosModel [id_producto=" + id_producto + ", imagen=" + imagen + ", nombre_producto="
					+ nombre_producto + ", descripcion=" + descripcion + ", precio=" + precio + "]";
		}
	
}
