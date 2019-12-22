package ga.snatchkart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ga.snatchkart.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}
