package com.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.Product;
import com.api.repository.ProductRepo;


@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductRepo product;

	@Override
	public List<Product> getAllProducts() {
		
		return product.findAll();
	}

	@Override
	public Product getById(Long id) {
		
		return product.findById(id).orElse(null);
	}

	
	

	@Override
	public String deleteById(Long id) {
		product.deleteById(id);
        return "Product deleted with ID: " + id;
	}

	@Override
	public Product updateProduct(Long id, Product updatedProduct) {
		 Optional<Product> optionalProduct = product.findById(id);
	        if (optionalProduct.isPresent()) {
	            Product existing = optionalProduct.get();
	            existing.setName(updatedProduct.getName());
	            existing.setPrice(updatedProduct.getPrice());
	            // Add more fields if needed
	            return product.save(existing);
	        } else {
	            return null;
	        }
	}

	@Override
	public Product addProduct(Product insertProduct) {
		
		return product.save(insertProduct);
	}
	
	

}
