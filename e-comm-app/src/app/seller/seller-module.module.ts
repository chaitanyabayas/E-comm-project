import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { SellerRoutingModule } from './seller-routing.module';
import { RegisterComponent } from './register/register.component';
import { CatagoryComponent } from './catagory/catagory.component';
import { SubcatagoryComponent } from './subcatagory/subcatagory.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [RegisterComponent, CatagoryComponent, SubcatagoryComponent],
  imports: [BrowserModule, CommonModule, SellerRoutingModule, HttpClientModule],
})
export class SellerModuleModule {}
