/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { OrcamentoFamiliarService } from './OrcamentoFamiliar.service';

describe('Service: OrcamentoFamiliar', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OrcamentoFamiliarService]
    });
  });

  it('should ...', inject([OrcamentoFamiliarService], (service: OrcamentoFamiliarService) => {
    expect(service).toBeTruthy();
  }));
});
