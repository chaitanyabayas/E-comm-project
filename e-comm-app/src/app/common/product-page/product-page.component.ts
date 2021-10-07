import { Component, OnInit } from '@angular/core';
import { ApiCallerService } from 'src/app/services/api-caller.service';
import { ProductServiceService } from 'src/app/services/product-service.service';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css'],
})
export class ProductPageComponent implements OnInit {
  product: any;
  constructor(
    private apiService: ProductServiceService,
    private apiCaller: ApiCallerService
  ) {}

  ngOnInit() {
    // this.apiService.getAllProducts().subscribe((data) => {
    //   this.product = data.productDTO;
    // });
  }

  countToCart() {}
}
