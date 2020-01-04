package ga.snatchkart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ga.snatchkart.model.User;
import ga.snatchkart.repository.UserRepository;
import ga.snatchkart.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<User> getUserById(Long userId) {
		return userRepository.findById(userId);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

}
