package ga.snatchkart.service;

import org.springframework.http.ResponseEntity;

import ga.snatchkart.config.PaytmPaymentApplicationProperties;

public interface PaymentService {
	
	ResponseEntity<String> capturePayment();
	ResponseEntity<PaytmPaymentApplicationProperties> getPaytmApplicationProperties() throws Exception;

}
