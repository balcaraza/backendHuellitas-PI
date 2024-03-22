package com.huellitas.huellitas.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.springframework.stereotype.Service;

import com.huellitas.huellitas.model.ProductosModel;

@Service
public class ProductService {
	public final ArrayList<ProductosModel> list=  new ArrayList<ProductosModel>();
	
	public ProductService ()
	{
	
		list.add(new ProductosModel( "RopaMinie.jpg","RopaMinie" ,"Ropa para mascota, disney minnie mouse, camisa textil, rosa y grande" , 145.80));
		list.add(new ProductosModel( "dssd.jpg","Ropa" ,"Ropa para mascota, disney minnie mouse" , 125.80));
		list.add(new ProductosModel( "Peluche dinosaurio.jpg","aghdjdhd" ,"Ropa para mascota, disney minnie mouse, camisa textil, rosa y grande" , 15.80));
	}

	public ArrayList<ProductosModel> getAllProducts() {
		return list;//devuelve la lista de productos
	}

	public ProductosModel getProduct(int prodId) {
		ProductosModel productoTemporal= null;
		for(ProductosModel product:list) {
			if(product.getId_producto()==prodId) {
				productoTemporal = product;
				break;		
			}
		}
		return productoTemporal;
	}
	//Si tu no tienes constructor vacio jamas funcionara, y si escribes Productsmolds menos lo hara
	public ProductosModel addProductModel(ProductosModel productosModel) {
		ProductosModel productoTemporal =null;
		if (list.add(productosModel)) {
			productoTemporal=productosModel;
		}
		return null;
	}

	public ProductosModel deleteProduct(int prodId) {
		ProductosModel productoTemporal=null;
		for(ProductosModel product:list) {
			if(product.getId_producto()==prodId) {
				productoTemporal=product;
				list.remove(product);//borra el producto de la lista;
				break;
			}
		}
		return null;
	}



	/*
	 //pediente en revision por error 500 de servidor, error de petic
	  public ProductosModel updateProductModel(int prodId, String imagen, String nombre_producto, String descripcion,
			Double precio) {
		// TODO Auto-generated method stub
		ProductosModel productoTemporal=null;
			for(ProductosModel product:list) {
				if(product.getId_producto()==prodId) {
					if(imagen.length()!=0) product.setImagen(imagen);
					if(nombre_producto.length()!=0) product.setDescripcion(descripcion);
					if(descripcion.length()!=0)product.setDescripcion(descripcion);
					if(precio.doubleValue()>0) product.setPrecio(precio);
					productoTemporal = product;
					break;
				}
			}
		return productoTemporal;
	}*/


	public ProductosModel updateProductModel(int prodId, String imagen, String nombre_producto, String descripcion,
			Double precio) {
		// TODO Auto-generated method stub
			ProductosModel productM=null;
			for (ProductosModel product:list) {
				if(product.getId_producto()==prodId) {
					if(imagen!=null)product.setImagen(imagen);
					if(nombre_producto!=null)product.setNombre_producto(nombre_producto);
					if(descripcion!=null)product.setDescripcion(descripcion);
					if(precio!=null)product.setPrecio(precio);
					productM=product;
					break;
					
				}
			}
			
		return productM;
	}
	
}
