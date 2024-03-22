package com.huellitas.huellitas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huellitas.huellitas.model.ProductosModel;
import com.huellitas.huellitas.service.ProductService;

@RestController//controlador
@RequestMapping(path="/api/products/")
public class productosController {
	
	private final ProductService productService;// variable service

	@Autowired
	public productosController(ProductService productService) {
		this.productService= productService;
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping
	public List<ProductosModel> getProduct(){
		return productService.getAllProducts();
		
	}
	
	@GetMapping (path = "prodId")
	public ProductosModel getProduct(@PathVariable("prodId")Long prodId) {
		return productService.getProduct(prodId);
	}
	
	@PostMapping
	public ProductosModel addProductModel(@RequestBody ProductosModel productosModel) {
		return productService.addProductModel(productosModel);
	}
	
	//Dell
	@DeleteMapping(path = "{prodId}")
	public ProductosModel deleteProduct(@PathVariable("prodId")Long prodId) {
		return productService.deleteProduct(prodId);
	}
	
	@PutMapping(path = "{prodId}")
	public ProductosModel updateProductModel(@PathVariable ("prodId") Long prodId,
			@RequestBody ProductosModel product) {
		return productService. updateProductModel(prodId, product.getImagen(),
				product.getNombreProducto(),product.getDescripcion(),
				Double.valueOf(product.getPrecio()));
	}
	
	
	
}