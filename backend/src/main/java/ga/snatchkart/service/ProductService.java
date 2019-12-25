package ga.snatchkart.service;

import java.util.List;

import ga.snatchkart.model.Product;

public interface ProductService {

	List<Product> getAllProducts();
	void saveAllProducts(List<Product> saveProducts);
	List<Product> getAllProductsByOffers();
	
}
