import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AppConstants } from 'src/app/services/AppConstants';
import { ProductServiceService } from 'src/app/services/product-service.service';
import { ToasterService } from 'src/app/services/toaster.service';

@Component({
  selector: 'app-add-edit-product',
  templateUrl: './add-edit-product.component.html',
  styleUrls: ['./add-edit-product.component.css'],
})
export class AddEditProductComponent implements OnInit, OnDestroy {
  ngOnDestroy(): void {
    throw new Error('Method not implemented.');
  }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  // subscription: any;
  // product: any;
  // loading = false;
  // productForm!: FormGroup;
  // ADD_URL: string;
  // EDIT_URL: string;
  // EVENTS_PARAMS = {
  //   ID: null,
  //   TITLE: '',
  //   TYPE: '',
  //   PRIORITY: '',
  // };
  // constructor(
  //   private apiCaller: ProductServiceService,
  //   private fb: FormBuilder,
  //   private toaster: ToasterService
  // ) {
  //   if (this.product) {
  //     this.EVENTS_PARAMS.ID = this.product.id;
  //     this.EVENTS_PARAMS.TITLE = this.product.title;
  //     this.EVENTS_PARAMS.TYPE = this.product.type;
  //     this.EVENTS_PARAMS.PRIORITY = this.product.priority;
  //   }
  //   this.ADD_URL = AppConstants.ADD_PRODUCT_URL;
  //   this.EDIT_URL = AppConstants.EDIT_PRODUCT_URL;
  // }
  // ngOnInit(): void {
  //   this.initFormsForm();
  // }
  // ngOnDestroy(): void {
  //   this.subscription.unsubscribe();
  // }
  // initFormsForm = () => {
  //   this.productForm = this.fb.group({
  //     id: this.EVENTS_PARAMS.ID,
  //     title: [
  //       this.EVENTS_PARAMS.TITLE,
  //       Validators.compose([Validators.required]),
  //     ],
  //     priority: [
  //       this.EVENTS_PARAMS.PRIORITY,
  //       Validators.compose([Validators.required, Validators.minLength(1)]),
  //     ],
  //   });
  // };
  // submit = () => {
  //   const controls = this.productForm.controls;
  //   if (this.productForm.invalid && !this.productForm.valid) {
  //     Object.keys(controls).forEach((controlName) =>
  //       controls[controlName].markAsTouched()
  //     );
  //     this.loading = false;
  //     return;
  //   }
  //   this.loading = true;
  //   var formData = new FormData();
  //   if (this.product) formData.append('id', this.productForm.value['id']);
  //   formData.append('title', this.productForm.value['title']);
  //   formData.append('type', 'EVENTS');
  //   formData.append('priority', this.productForm.value['priority']);
  //   if (this.productForm.value['id'])
  //     this.apiCaller.apiFormDataPostCall(this.EDIT_URL, formData).subscribe(
  //       (data) => {
  //         this.toaster.getToastMessage(
  //           data.message,
  //           'success',
  //           3000,
  //           'top-end'
  //         );
  //       },
  //       (error) => {
  //         this.loading = false;
  //       }
  //     );
  //   else
  //     this.apiCaller.apiFormDataPostCall(this.ADD_URL, formData).subscribe(
  //       (data) => {
  //         this.toaster.getToastMessage(
  //           data.message,
  //           'success',
  //           3000,
  //           'top-end'
  //         );
  //       },
  //       (error) => {
  //         this.loading = false;
  //       }
  //     );
  // };
  // isControlHasError(controlName: string, validationType: string): boolean {
  //   const control = this.productForm.controls[controlName];
  //   if (!control) {
  //     return false;
  //   }
  //   const result =
  //     control.hasError(validationType) && (control.dirty || control.touched);
  //   return result;
  // }
  // numberOnly(event: any): boolean {
  //   const charCode = event.which ? event.which : event.keyCode;
  //   if (charCode > 31 && (charCode < 48 || charCode > 57)) {
  //     return false;
  //   }
  //   return true;
  // }
}
