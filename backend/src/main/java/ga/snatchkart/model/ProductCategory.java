package ga.snatchkart.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class ProductCategory implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@NotNull
	private String code;
	private LocalDateTime createdOn;
}
