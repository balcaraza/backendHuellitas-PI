package com.huellitas.huellitas.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.huellitas.huellitas.model.ProductosModel;
import com.huellitas.huellitas.repository.ProductRepository;

@Service
public class ProductService {
	public final ProductRepository productRepository;
	
	@Autowired
	public ProductService (ProductRepository productRepository){
		this.productRepository= productRepository;
	
	}
	
	public List<ProductosModel> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public ProductosModel getProduct(Long prodId) {
		return productRepository.findById(prodId).orElseThrow(
				()-> new IllegalArgumentException("El producto con el id ["
						+ prodId+"]no esta contemplado en nuestra base de datos"));
	}
	
	//Si tu no tienes constructor vacio jamas funcionara, y si escribes Productsmolds menos lo hara
	public ProductosModel addProductModel(ProductosModel productosModel) {
		Optional<ProductosModel> tmpproduct= productRepository.findByNombreProducto(productosModel.getNombreProducto());
		if(tmpproduct.isEmpty()) {
			return productRepository.save(productosModel);
		}else {
			System.out.println("El producto ["
					+ productosModel.getNombreProducto()+"] ya existe en nuestra base de datos");
			return null;
		}
	}

	public ProductosModel deleteProduct(Long prodId) {
		ProductosModel productoTemporal=null;
		if(productRepository.existsById(prodId)) {
			productoTemporal= productRepository.findById(prodId).get();//trae el producto
			productRepository.deleteById(Long.valueOf(prodId));
		}
		return productoTemporal;
	}



	public ProductosModel updateProductModel(Long prodId, String imagen, String nombre_producto, String descripcion,
			Double precio) {
		// TODO Auto-generated method stub
			ProductosModel product=null;
			
				if(productRepository.existsById(prodId)) {
					product=productRepository.findById(prodId).get();
					if(imagen.length()!=0)product.setImagen(imagen);
					if(nombre_producto.length()!=0)product.setNombreProducto(descripcion);
					if(descripcion.length()!=0)product.setDescripcion(descripcion);
					if(precio.doubleValue()>0)product.setPrecio(precio);//<-revisa este en el product model
					productRepository.save(product);
					
					
				}
			
			
		return product;
	}



	
}
