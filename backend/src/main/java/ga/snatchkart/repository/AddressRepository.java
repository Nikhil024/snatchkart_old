package ga.snatchkart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ga.snatchkart.model.Address;

@Repository
public interface AddressRepository extends MongoRepository<Address, String> {

}
