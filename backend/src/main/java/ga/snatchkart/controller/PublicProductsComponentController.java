package ga.snatchkart.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ga.snatchkart.model.Product;
import ga.snatchkart.model.ProductCategory;
import ga.snatchkart.service.ProductService;

@RestController
@RequestMapping("/products")
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

	@PutMapping("/save")
	public ResponseEntity<String> saveAllProducts() {
		List<Product> product = new ArrayList<>();

		product.add(new Product("Samsung Galaxy Note 8", 64000D, new ProductCategory("SMG-8", LocalDateTime.now()),
				"SMG-8", true, 30000D, true, 10L, LocalDateTime.now(), LocalDateTime.now()));
		product.add(new Product("Samsung Galaxy Note 9", 68000D, new ProductCategory("SMG-9", LocalDateTime.now()),
				"SMG-9", true, 42000D, true, 10L, LocalDateTime.now(), LocalDateTime.now()));
		product.add(new Product("Samsung Galaxy Note 10", 72000D, new ProductCategory("SMG-10", LocalDateTime.now()),
				"SMG-10", true, 55000D, false, 10L, LocalDateTime.now(), LocalDateTime.now()));
		product.add(new Product("Samsung Galaxy Note 11", 84000D, new ProductCategory("SMG-11", LocalDateTime.now()),
				"SMG-11", false, null, true, 10L, LocalDateTime.now(), LocalDateTime.now()));
		product.add(new Product("Samsung Galaxy Note 12", 90000D, new ProductCategory("SMG-12", LocalDateTime.now()),
				"SMG-12", false, null, true, 10L, LocalDateTime.now(), LocalDateTime.now()));
		product.add(new Product("Samsung Galaxy Note 13", 93000D, new ProductCategory("SMG-13", LocalDateTime.now()),
				"SMG-13", true, 38000D, true, 10L, LocalDateTime.now(), LocalDateTime.now()));
		product.add(new Product("Samsung Galaxy Note 14", 98000D, new ProductCategory("SMG-14", LocalDateTime.now()),
				"SMG-14", false, null, false, 10L, LocalDateTime.now(), LocalDateTime.now()));
		

		try {
			product.forEach(System.out::println);
			productService.saveAllProducts(product);
			return new ResponseEntity<String>("Added Products", HttpStatus.OK);
		} catch (DuplicateKeyException de) {
			return new ResponseEntity<String>("Products Already exists, please check request!"+de.toString(),HttpStatus.CONFLICT);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Products saving Failure!", HttpStatus.BAD_REQUEST);
		}
	}

}
