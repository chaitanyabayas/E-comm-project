import { Component, OnDestroy, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent implements OnInit, OnDestroy {
  subscriptionRoute: any;
  MENU: any;
  currentRoute: any;
  isCurrentURL: any;

  constructor(private router: Router) {
    this.subscriptionRoute = this.router.events.subscribe((val) => {
      this.currentRoute = val as NavigationEnd;

      if (this.currentRoute.url) {
        this.isCurrentURL = this.currentRoute.url;
      }
    });

    this.MENU = [
      {
        title: 'Home',
        url: 'home',
      },
      {
        title: 'About Us',
        child: [
          {
            title: 'About SP',
            url: 'aboutSP',
          },
          {
            title: 'Message From SP',
            url: 'massageFromSP',
          },
          {
            title: 'Out Team',
            url: 'ourTeam',
          },
          {
            title: 'Succession List',
            url: 'successionList',
          },
        ],
      },
      {
        title: 'Citizen Services',
        child: [
          {
            title: 'Appointment With SP',
            url: 'appointment',
          },
          {
            title: 'Citizen Report',
            url: 'citizenReport',
          },
          {
            title: 'Complaint',
            url: 'complaint',
          },
          {
            title: 'Passport',
            url: 'passport',
          },
          {
            title: 'FeedBack',
            url: 'feedBack',
          },
        ],
      },
      {
        title: 'Contact US',
        url: 'contact',
      },
    ];
  }
  ngOnDestroy(): void {
    this.subscriptionRoute.unsubscribe();
  }

  ngOnInit(): void {}
}
