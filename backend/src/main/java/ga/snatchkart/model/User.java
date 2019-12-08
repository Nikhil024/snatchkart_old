package ga.snatchkart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ga.snatchkart.enumration.UserRole;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {
	@Id
	private String id;
	private String name;
	@NotNull
	@Email
	private String email;
	private String imageUrl;
	private Boolean emailVerified = false;
	@JsonIgnore
	@NotNull
	private String password;
	@NotNull
	private AuthProvider provider;
	private String providerId;
	@NotNull
	private UserRole role;
	private List<Order> order;
	private List<Address> address;
	@NotNull
	private LocalDateTime lastUpdated;
}
