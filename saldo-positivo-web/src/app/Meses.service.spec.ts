/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { MesesService } from './Meses.service';

describe('Service: Meses', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MesesService]
    });
  });

  it('should ...', inject([MesesService], (service: MesesService) => {
    expect(service).toBeTruthy();
  }));
});
