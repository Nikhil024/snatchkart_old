package ga.snatchkart.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String firstName;
	private String lastName;
	private String doorNo;
	private String streetNumber;
	private String stateName;
	private String country;
	private String postCode;
	private String userId;
	private LocalDateTime lastUpdated;

}
