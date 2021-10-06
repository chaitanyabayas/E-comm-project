import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Seller } from '../model/Seller';
import { Product } from '../model/Product';
import { Catagory } from '../model/Catagory';
import { SubCatagory } from '../model/SubCatagory';

@Injectable()
//   {
//   providedIn: 'root',
// }
export class ApiCallerService {
  private productsUrl: string;
  private sellerRegisterUrl: string;
  private sellerRegisterConfirmUrl: string;
  private sellerLoginUrl: string;
  private getCatagoryUrl: string;
  private getSubCatagoryUrl: string;

  constructor(private http: HttpClient) {
    this.sellerRegisterUrl =
      'http://localhost:8762/ecommerce/sellerService/seller/userRegister';
    this.sellerRegisterConfirmUrl =
      'http://localhost:8762/ecommerce/sellerService/seller/confirmAccount';
    this.sellerLoginUrl =
      'http://localhost:8762/ecommerce/sellerService/seller/userLogin';
    this.productsUrl =
      'http://localhost:8762/ecommerce/sellerService/product/getProducts';
      this.getCatagoryUrl =
      'http://localhost:8762/ecommerce/sellerService/product/getProducts';
      this.getSubCatagoryUrl =
      'http://localhost:8762/ecommerce/sellerService/product/getProducts';
  }

  //to register seller
  public registerSeller(seller: Seller[]) {
    return this.http.post<Seller[]>(this.sellerRegisterUrl, seller);
  }

  //to confirm seller registration
  public confirmRegisterSeller(seller: Seller[]) {
    return this.http.post<Seller[]>(this.sellerRegisterConfirmUrl, seller);
  }

  //to confirm seller login
  public loginSeller(seller: Seller[]) {
    return this.http.post<Seller[]>(this.sellerLoginUrl, seller);
  }

  //get all products list
  public findAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productsUrl);
  }
  
  //get all products list
  public findAllCatagory(): Observable<Catagory[]> {
    return this.http.get<Catagory[]>(this.getCatagoryUrl);
  }
  
  //get all products list
  public findAllSubcatagory(): Observable<SubCatagory[]> {
    return this.http.get<SubCatagory[]>(this.getSubCatagoryUrl);
  }
}
