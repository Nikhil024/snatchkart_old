package ga.snatchkart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategory extends MongoRepository<ProductCategory, String> {

}
