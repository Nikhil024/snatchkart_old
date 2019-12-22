package ga.snatchkart.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ga.snatchkart.model.Login;
import ga.snatchkart.model.SignUp;
import ga.snatchkart.payload.AuthResponse;
import ga.snatchkart.service.JWTAuthenticationService;

@RestController
@RequestMapping("/auth")
public class PublicAuthenticationComponentController {

	@Autowired
	private JWTAuthenticationService authenticationService;


	@PostMapping("/login")
	public ResponseEntity<AuthResponse> authenticateUser(@Valid @RequestBody Login loginRequest,
			HttpServletResponse response) {
		return authenticationService.login(loginRequest, response);
	}

	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@Valid @RequestBody SignUp signUpRequest) {
		return authenticationService.signUp(signUpRequest);
	}

}
