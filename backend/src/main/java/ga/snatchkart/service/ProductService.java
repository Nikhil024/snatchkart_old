package ga.snatchkart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ga.snatchkart.model.Product;

public interface ProductService {

	List<Product> getAllProducts();
	ResponseEntity<String> saveAllProducts();
	List<Product> getAllProductsByOffers();
	
}
