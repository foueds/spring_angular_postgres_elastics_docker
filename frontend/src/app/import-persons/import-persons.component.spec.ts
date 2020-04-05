import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportPersonsComponent } from './import-persons.component';

describe('ImportPersonsComponent', () => {
  let component: ImportPersonsComponent;
  let fixture: ComponentFixture<ImportPersonsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportPersonsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportPersonsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
