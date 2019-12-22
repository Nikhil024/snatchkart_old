package ga.snatchkart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ga.snatchkart.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
