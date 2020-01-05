import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../payment.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent implements OnInit {

  constructor(private paymentService: PaymentService, private http: HttpClient) { 
  }

  ngOnInit() {
  }


// I have all below fields values
paytm = {
  MID: "hAfKWw64884392439641&", // paytm provide
  WEBSITE: "WEBSTAGING", // paytm provide
  INDUSTRY_TYPE_ID: "Retail", // paytm provide
  CHANNEL_ID: "WEB", // paytm provide
  ORDER_ID: "1892", // unique id
  CUST_ID: "12039", // customer id
  MOBILE_NO: "9768765654", // customer mobile number
  EMAIL: "nikhil.iy@gmail.com", // customer email
  TXN_AMOUNT: "10.00", // transaction amount
  CALLBACK_URL: "http://localhost:4200/pamentSuccess", // Call back URL that i want to redirect after payment fail or success
};

submitForm() {

  this.paymentService.capturePayment().subscribe(
    response => {
      this.paytm['CHECKSUMHASH'] = response['checkSum'];
      this.createPaytmForm();
    },
    error => console.log(error)
  );

/*   // I will do API call and will get CHECKSUMHASH.
  this.http.post('https://myAPI.com/createchecksum', this.paytm)
     .subscribe((res: any) => {
           // As per my backend i will get checksumhash under res.data
           this.paytm['CHECKSUMHASH'] = res.data;
           // than i will create form
           this.createPaytmForm();
      },
      error => console.log(error));    */ 
}

createPaytmForm() {
 const my_form: any = document.createElement('form');
  my_form.name = 'paytm_form';
  my_form.method = 'post';
  my_form.action = 'https://securegw-stage.paytm.in/order/process';

  const myParams = Object.keys(this.paytm);
  for (let i = 0; i < myParams.length; i++) {
    const key = myParams[i];
    let my_tb: any = document.createElement('input');
    my_tb.type = 'hidden';
    my_tb.name = key;
    my_tb.value = myParams[key];
    my_form.appendChild(my_tb);
  };

  document.body.appendChild(my_form);
  my_form.submit();
// after click will fire you will redirect to paytm payment page.
// after complete or fail transaction you will redirect to your CALLBACK URL
};




}
