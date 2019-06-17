/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { LancamentoTituloService } from './LancamentoTitulo.service';

describe('Service: LancamentoTitulo', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LancamentoTituloService]
    });
  });

  it('should ...', inject([LancamentoTituloService], (service: LancamentoTituloService) => {
    expect(service).toBeTruthy();
  }));
});
