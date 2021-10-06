import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubcatagoryComponent } from './subcatagory.component';

describe('SubcatagoryComponent', () => {
  let component: SubcatagoryComponent;
  let fixture: ComponentFixture<SubcatagoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubcatagoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubcatagoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
