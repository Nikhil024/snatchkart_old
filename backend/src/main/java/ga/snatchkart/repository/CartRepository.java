package ga.snatchkart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ga.snatchkart.model.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

}
