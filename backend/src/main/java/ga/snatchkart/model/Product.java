package ga.snatchkart.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	@NotNull
	private Double value;
	@NotNull
	private ProductCategory productCategory;
	@NotNull
	private String sku;
	private Boolean inOffer;
	private Double offerPrice;
	private Boolean inStock;
	private Long stocks;
	
	private LocalDateTime createdOn;
	@NotNull
	private LocalDateTime lastUpdated;
}
