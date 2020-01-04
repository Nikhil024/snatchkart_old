package ga.snatchkart.service.impl;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ga.snatchkart.config.PaytmPaymentApplicationProperties;
import ga.snatchkart.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaytmPaymentApplicationProperties paytmPaymentApplicationProperties;
	
	
	@Override
	public ResponseEntity<String> capturePayment() {
		System.out.println(paytmPaymentApplicationProperties.toString());
		return null;
	}


	@Override
	public ResponseEntity<PaytmPaymentApplicationProperties> getPaytmApplicationProperties() {
		return new ResponseEntity<PaytmPaymentApplicationProperties>(paytmPaymentApplicationProperties, HttpStatus.OK);
	}

}
