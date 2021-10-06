import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Seller } from 'src/app/model/Seller';
import { User } from 'src/app/model/user';
import { ApiCallerService } from 'src/app/services/api-caller.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  seller!: Seller[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: ApiCallerService
  ) {}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  onSubmit() {
    this.userService
      .registerSeller(this.seller)
      .subscribe((result) => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/seller/register']);
  }
}
