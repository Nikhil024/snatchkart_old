package ga.snatchkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ga.snatchkart.config.PaytmPaymentApplicationProperties;
import ga.snatchkart.service.PaymentService;

@RestController
@RequestMapping("/secure/payments")
public class ProtectedPaymentComponentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/properties")
	public ResponseEntity<PaytmPaymentApplicationProperties> getPaytmApplicationProperties() {
		return paymentService.getPaytmApplicationProperties();
	}

	@PostMapping("/capture")
	public ResponseEntity<String> capturePayment() {
		return paymentService.capturePayment();
	}

}
