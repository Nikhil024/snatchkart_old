package ga.snatchkart.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ga.snatchkart.model.Login;
import ga.snatchkart.model.SignUp;
import ga.snatchkart.payload.AuthResponse;

@Service
public interface JWTAuthenticationService {
	ResponseEntity<AuthResponse> login(Login loginRequest, HttpServletResponse response);
	ResponseEntity<String> signUp(SignUp signUpRequest);
}
