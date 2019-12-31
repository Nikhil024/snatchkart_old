package ga.snatchkart.service;

import org.springframework.http.ResponseEntity;

import ga.snatchkart.model.Cart;

public interface CartService {
	ResponseEntity<String> saveCart(Cart cart);
}
