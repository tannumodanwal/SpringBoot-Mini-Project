package com.api.services;




import java.util.List;

import org.springframework.stereotype.Service;

import com.api.model.Product;






@Service
public interface ProductService {

	    public List<Product> getAllProducts();
		
		public Product getById(Long id);
		
		public Product addProduct(Product insertProduct);
		
		public Product updateProduct(Long id, Product updatedProduct);
		
		public String deleteById(Long id);
		
	
	
	
}
