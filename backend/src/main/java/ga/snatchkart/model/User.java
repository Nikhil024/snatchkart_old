package ga.snatchkart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ga.snatchkart.enumration.AuthProvider;
import ga.snatchkart.enumration.UserRole;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {
	@Id
	private Long id;
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	private String name;
	@NotNull
	@Email
	@Indexed(unique = true, sparse = true)
	private String email;
	private String imageUrl;
	private Boolean emailVerified = false;
	@JsonIgnore
	@NotNull
	private String password;
	@NotNull
	private AuthProvider provider;
	@NotNull
	private UserRole role;
	private String providerId;
	private List<Order> order;
	private List<Address> address;
	@NotNull
	private LocalDateTime lastUpdated;
}
