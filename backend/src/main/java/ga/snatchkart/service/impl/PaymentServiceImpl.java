package ga.snatchkart.service.impl;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paytm.pg.merchant.CheckSumServiceHelper;

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
	public ResponseEntity<PaytmPaymentApplicationProperties> getPaytmApplicationProperties() throws Exception {
		TreeMap<String, String> parameters = new TreeMap<>();
		paytmPaymentApplicationProperties.getDetails().forEach((k, v) -> parameters.put(k, v));
		parameters.put("MOBILE_NO", "9739010959");
		parameters.put("EMAIL", "nikhil.iy@gmil.com");
		parameters.put("ORDER_ID", "234");
		parameters.put("TXN_AMOUNT", "10.00");
		parameters.put("CUST_ID", "124");
		String checksum = getCheckSum(parameters);

		paytmPaymentApplicationProperties.setCheckSum(checksum);
		boolean isValideChecksum = validateCheckSum(parameters, checksum);
		System.out.println("aaaaaaaaaaaaaaaa: " + isValideChecksum);
		return new ResponseEntity<PaytmPaymentApplicationProperties>(paytmPaymentApplicationProperties, HttpStatus.OK);
	}

	private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		return CheckSumServiceHelper.getCheckSumServiceHelper()
				.genrateCheckSum(paytmPaymentApplicationProperties.getMerchantKey(), parameters);
	}

	private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
		return CheckSumServiceHelper.getCheckSumServiceHelper()
				.verifycheckSum(paytmPaymentApplicationProperties.getMerchantKey(), parameters, paytmChecksum);
	}

}
