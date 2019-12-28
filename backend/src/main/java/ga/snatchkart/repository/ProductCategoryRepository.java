package ga.snatchkart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ga.snatchkart.model.ProductCategory;

@Repository
public interface ProductCategoryRepository extends MongoRepository<ProductCategory, String> {
}
