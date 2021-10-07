import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './common/home/home.component';
import { MenuComponent } from './common/menu/menu.component';
import { ProductPageComponent } from './common/product-page/product-page.component';
import { AddEditProductComponent } from './product/add-edit-product/add-edit-product.component';
import { LoginComponent } from './common/login/login.component';
import { RegisterComponent } from './common/register/register.component';

@NgModule({
  declarations: [AppComponent, HomeComponent, MenuComponent, ProductPageComponent, AddEditProductComponent, LoginComponent, RegisterComponent],
  imports: [BrowserModule, AppRoutingModule,HttpClientModule,
    FormsModule, ReactiveFormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
