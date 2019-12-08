package ga.snatchkart.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ga.snatchkart.enumration.OrderStatus;
import lombok.Data;

@Data
@Document
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@NotNull
	private LocalDateTime orderDate;
	@NotNull
	private OrderStatus orderStatus;
	@NotNull
	private List<Product> products;
	@NotNull
	private Payment paymentDetails;
	@NotNull
	private LocalDateTime lastUspdated;
}
