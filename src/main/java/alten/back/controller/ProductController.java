package alten.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import alten.back.model.Product;
import alten.back.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public Iterable<Product> getProducts() {
		return productService.getAllProducts();
	}

	@PostMapping("/products")
	public Product createProduct(Product product) {
		return productService.createProduct(product);
	}

	@GetMapping("/products/{id}")
	public Product getProductById(Integer id) {
		Product product = productService.getProductById(id);
		return product;
	}

	@PatchMapping("/products/{id}")
	public Product updateProduct(Integer id, Product product) {
		Product p = productService.getProductById(id);
		if(p != null) {
			productService.updateProduct(product);
			return product;
		} else {
			return null;
		}
	}

	@DeleteMapping("/products/{id}")
	public void deleteProduct(Integer id) {
		productService.deleteProduct(id);
	}

}
