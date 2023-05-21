import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PruebaLoginComponent } from './prueba-login.component';

describe('PruebaLoginComponent', () => {
  let component: PruebaLoginComponent;
  let fixture: ComponentFixture<PruebaLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PruebaLoginComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PruebaLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
