import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PaymentComponent } from './payment/payment.component';
import { PaymentService } from './payment.service';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { PamentSuccessComponent } from './pament-success/pament-success.component';

@NgModule({
  declarations: [
    AppComponent,
    PaymentComponent,
    PamentSuccessComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    PaymentService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
