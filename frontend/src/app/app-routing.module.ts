import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PaymentComponent } from './payment/payment.component';
import { PamentSuccessComponent } from './pament-success/pament-success.component';


const routes: Routes = [
  {path: 'payment', component: PaymentComponent},
  {path: 'pamentSuccess', component: PamentSuccessComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
