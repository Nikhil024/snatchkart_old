package ga.snatchkart.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ga.snatchkart.enumration.CardType;
import lombok.Data;

@Data
@Document
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@NotNull
	private Long cardNumber;
	@NotNull
	private CardType cardType;
	@NotNull
	private String cardExpiry;

}
