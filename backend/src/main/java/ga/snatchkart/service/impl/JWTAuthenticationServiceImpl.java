package ga.snatchkart.service.impl;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ga.snatchkart.enumration.AuthProvider;
import ga.snatchkart.enumration.UserRole;
import ga.snatchkart.exception.BadRequestException;
import ga.snatchkart.model.Login;
import ga.snatchkart.model.SignUp;
import ga.snatchkart.model.User;
import ga.snatchkart.payload.ApiResponse;
import ga.snatchkart.payload.AuthResponse;
import ga.snatchkart.repository.UserRepository;
import ga.snatchkart.service.CookieService;
import ga.snatchkart.service.JWTAuthenticationService;
import ga.snatchkart.service.SequenceGenerator;

@Service
public class JWTAuthenticationServiceImpl implements JWTAuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SequenceGenerator sequenceGeneratorService;
	
	@Override
	public ResponseEntity<AuthResponse> login(Login loginRequest, HttpServletResponse response) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = tokenProvider.createToken(authentication);
		CookieService.addCookie(response, "bearer", token, 100);
		
		return new ResponseEntity<AuthResponse> (new AuthResponse(token), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> signUp(SignUp signUpRequest) {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			throw new BadRequestException("Email address already in use.");
		}

		// Creating user's account
		User user = new User();
		user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
		user.setName(signUpRequest.getName());
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(signUpRequest.getPassword());
		user.setProvider(AuthProvider.LOCAL);
		user.setRole(UserRole.ROLE_USER);
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		User result = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/me")
				.buildAndExpand(result.getId()).toUri();

		return new ResponseEntity<String> ("User registered successfully@", HttpStatus.OK);
	}

}
