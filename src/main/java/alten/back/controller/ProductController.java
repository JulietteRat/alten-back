package alten.back.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alten.back.model.Product;
import alten.back.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@Operation(security = { @SecurityRequirement(name = "basicAuth") })
	@GetMapping("/products")
	public ResponseEntity<Iterable<Product>> getProducts() {
	    Iterable<Product> products = productService.getAllProducts();
	    if (!products.iterator().hasNext()) {
	        return ResponseEntity.noContent().build();
	    }
	    return ResponseEntity.ok(products);
	}

	@Operation(security = { @SecurityRequirement(name = "basicAuth") })
	@PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product newProduct) {
		if (newProduct == null) {
			return ResponseEntity.noContent().build();
    	}
    	Product existingProduct = productService.getProductById(newProduct.getId());
    	if (existingProduct != null) {
    		return ResponseEntity.badRequest().build();
    	}
    	newProduct.setCreatedAt(Instant.now().getEpochSecond());
        Product createdProduct = productService.createProduct(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

	@Operation(security = { @SecurityRequirement(name = "basicAuth") })
	@GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product existingProduct = productService.getProductById(id);
        if (existingProduct != null) {
            return ResponseEntity.ok(existingProduct); 
        } else {
            return ResponseEntity.notFound().build(); 
        }
	}

	@Operation(security = { @SecurityRequirement(name = "basicAuth") })
	@PatchMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product updatedProduct) {
		if (updatedProduct == null) {
			ResponseEntity.noContent().build();
    	}
		Product existingProduct = productService.getProductById(id);
		if(existingProduct != null) {
			updatedProduct.setUpdatedAt(Instant.now().getEpochSecond());
			productService.updateProduct(updatedProduct);
			return ResponseEntity.ok(updatedProduct);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Operation(security = { @SecurityRequirement(name = "basicAuth") })
	@DeleteMapping("/products/{id}")	
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
		Product existingProduct = productService.getProductById(id);
        if (existingProduct != null) {
        	productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
