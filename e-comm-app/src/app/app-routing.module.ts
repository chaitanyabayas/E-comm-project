import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './common/login/login.component';
import { ProductPageComponent } from './common/product-page/product-page.component';
import { RegisterComponent } from './common/register/register.component';
import { AddEditProductComponent } from './product/add-edit-product/add-edit-product.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent,
    children: [
      { path: '', redirectTo: 'login', pathMatch: 'full' },
      { path: 'home', component: ProductPageComponent },
      { path: 'addProduct', component: AddEditProductComponent },
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
