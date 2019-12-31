package ga.snatchkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ga.snatchkart.model.Cart;
import ga.snatchkart.security.UserPrincipal;
import ga.snatchkart.service.CartService;

@RestController
@RequestMapping("/secure/cart")
public class ProtectedCartComponentController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/get")
	public ResponseEntity<Cart> getCartOfUser(UserPrincipal principalInfo){
		return new ResponseEntity<Cart>(new Cart(), HttpStatus.OK);
	}

}
