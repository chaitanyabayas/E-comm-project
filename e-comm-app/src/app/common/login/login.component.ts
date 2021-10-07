import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { select, Store } from '@ngrx/store';
import { User } from 'src/app/models/user';
import { ApiCallerService } from 'src/app/services/api-caller.service';
import { ToasterService } from 'src/app/services/toaster.service';
import * as moment from 'moment';
import { UserServiceService } from 'src/app/services/user-service.service';
import { AppConstants } from 'src/app/services/AppConstants';

const LOGIN_PARAMS = {
  EMAIL: '',
  PASSWORD: '',
};

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit, OnDestroy {
  subscription: any;
  // Public params
  loginForm!: FormGroup;
  loading = false;
  errors: any = [];
  passwordIcon: string = 'VISIBLE';

  LOGIN_URL: string;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private appStore: Store<{ auth: any }>,
    private store: Store<{ auth: User }>,
    private toast: ToasterService,
    private apiService: ApiCallerService,
    private apiCaller: UserServiceService
  ) {
    this.subscription = this.store.pipe(select('auth')).subscribe((data) => {
      if (data) {
        if (data.isAuthenticated) {
          if (
            data.user.tokenValidity &&
            moment(data.user.tokenValidity).isAfter(new Date())
          )
            this.router.navigate(['official/dashboard']);

          // if (!data.user.tnc_accepted) this.router.navigate(['tnc']);
          // else this.router.navigate(['verify']);
        }
      }
    });

    this.LOGIN_URL = AppConstants.SELLER_LOGIN_URL;
  }
  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  ngOnInit(): void {
    // this.appStore.dispatch(new AppLoadderHide({}));
    this.initLoginForm();
  }

  initLoginForm() {
    this.loginForm = this.fb.group({
      email: [
        LOGIN_PARAMS.EMAIL,
        Validators.compose([
          Validators.required,
          Validators.email,
          Validators.minLength(3),
          Validators.maxLength(320),
        ]),
      ],
      password: [
        LOGIN_PARAMS.PASSWORD,
        Validators.compose([
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(100),
        ]),
      ],
    });
  }

  submit() {
    const controls = this.loginForm.controls;

    if (this.loginForm.invalid && !this.loginForm.valid) {
      Object.keys(controls).forEach((controlName) =>
        controls[controlName].markAsTouched()
      );
      return;
    }

    this.loading = true;

    this.apiCaller.makeAuthCall(this.LOGIN_URL, this.loginForm.value).subscribe(
      (data) => {
        this.store.dispatch(data.userDTO);
        this.toast.getToastMessage(data.message, 'success', 3000, 'bottom-end');
        this.router.navigate(['/dashboard']);
      },
      (error) => {
        this.loading = false;
      }
    );
  }
}
