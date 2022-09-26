import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatenightComponent } from './datenight.component';

describe('DatenightComponent', () => {
  let component: DatenightComponent;
  let fixture: ComponentFixture<DatenightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DatenightComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DatenightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
