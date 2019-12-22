package ga.snatchkart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ga.snatchkart.model.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {

}
