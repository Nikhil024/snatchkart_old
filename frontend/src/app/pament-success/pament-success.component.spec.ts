import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PamentSuccessComponent } from './pament-success.component';

describe('PamentSuccessComponent', () => {
  let component: PamentSuccessComponent;
  let fixture: ComponentFixture<PamentSuccessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PamentSuccessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PamentSuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
