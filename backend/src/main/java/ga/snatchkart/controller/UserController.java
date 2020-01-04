package ga.snatchkart.controller;

import ga.snatchkart.exception.ResourceNotFoundException;
import ga.snatchkart.model.User;
import ga.snatchkart.repository.UserRepository;
import ga.snatchkart.security.CurrentUser;
import ga.snatchkart.security.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository usersRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return usersRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
