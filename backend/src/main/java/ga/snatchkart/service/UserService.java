package ga.snatchkart.service;

import java.util.Optional;

import ga.snatchkart.model.User;

public interface UserService {
	Optional<User> getUserById(Long userId);
	void save(User user);
}
