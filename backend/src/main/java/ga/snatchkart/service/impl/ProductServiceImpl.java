package ga.snatchkart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ga.snatchkart.model.Product;
import ga.snatchkart.repository.ProductRepository;
import ga.snatchkart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void saveAllProducts(List<Product> saveProducts) {
		productRepository.saveAll(saveProducts);
		
	}

	@Override
	public List<Product> getAllProductsByOffers() {
		return productRepository.findByInOffer(true);
	}

}
