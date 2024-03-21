package com.huellitas.huellitas.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huellitas.huellitas.model.ProductosModel;
import com.huellitas.huellitas.service.ProductService;

@RestController
@RequestMapping("/api/products/")
public class productosController {
	
	private final ProductService productService;// variable service

	@Autowired
public productosController(ProductService productService) {
	this.productService= productService;//instancia de la clase. 
}
	@GetMapping
	public ArrayList<ProductosModel> getProduct(){
		return productService.getAllProducts();
		
	}
	//get para un solo producto.
	@GetMapping (path = "{prodId}")
	public ProductosModel getProduct(@PathVariable("prodId")int prodId) {
		return productService.getProduct(prodId);
	}
	
	@PostMapping
	public ProductosModel addProductModel(@RequestBody ProductosModel productosModel) {
		return productService.addProductModel(productosModel);
	}
	
	//Dell
	@DeleteMapping(path = "{prodId}")
	public ProductosModel deleteProduct(@PathVariable("prodId")int prodId) {
		return productService.deleteProduct(prodId);
	}
	@PutMapping(path = "{prodId}")
	public ProductosModel updateProductModel(@PathVariable("{prodId}" )int prodId,
			@RequestBody ProductosModel productosModel) {
		
		return productService.updateProductModel(prodId, 
				productosModel.getImagen(),
				productosModel.getNombre_producto(),
				productosModel.getDescripcion(),
				Double.valueOf(productosModel.getPrecio()));
		
	}
	
	
}