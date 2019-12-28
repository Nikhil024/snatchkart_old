package ga.snatchkart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ga.snatchkart.model.Product;
import ga.snatchkart.service.ProductService;

@RestController
@RequestMapping("/public/products")
public class PublicProductsComponentController {

	@Autowired
	private ProductService productService;

	@GetMapping("/all")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/allWithOffers")
	public List<Product> getAllProductsWithOffers() {
		return productService.getAllProductsByOffers();
	}
}
