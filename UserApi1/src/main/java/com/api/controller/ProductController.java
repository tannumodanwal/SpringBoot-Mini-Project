package com.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.model.Product;
import com.api.repository.ProductRepo;
import com.api.services.ProductService;



@RestController
@RequestMapping("/api/product")
public class ProductController {

	
	 @Autowired
     private ProductService productService;	
	 
	    
	   // Get all products
	    @GetMapping
	    public ResponseEntity<List<Product>> getAllProducts() {
	        List<Product> products = productService.getAllProducts();
	        return ResponseEntity.ok(products); // 200 OK
	    }

	    //Get product by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
	        Product product = productService.getById(id);
	        if (product != null) {
	            return ResponseEntity.ok(product); // 200 OK
	        } else {
	            return ResponseEntity.notFound().build(); // 404 Not Found
	        }
	    }

	    // Add new product
	    @PostMapping
	    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
	        Product saved = productService.addProduct(product);
	        return ResponseEntity.ok(saved); // 200 OK (You can use 201 Created also)
	    }

	    // Update product
	    @PutMapping("/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
	        Product updated = productService.updateProduct(id, updatedProduct);
	        if (updated != null) {
	            return ResponseEntity.ok(updated); // 200 OK
	        } else {
	            return ResponseEntity.notFound().build(); // 404 Not Found
	        }
	    }

	    //Delete product
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
	        String result = productService.deleteById(id);
	        return ResponseEntity.ok(result); // 200 OK
	    }
	 
	}
	

