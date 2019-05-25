import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrcamentoFamiliarComponent } from './orcamento-familiar.component';

describe('OrcamentoFamiliarComponent', () => {
  let component: OrcamentoFamiliarComponent;
  let fixture: ComponentFixture<OrcamentoFamiliarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrcamentoFamiliarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrcamentoFamiliarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
