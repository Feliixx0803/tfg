import { TestBed } from '@angular/core/testing';

import { ValidadorFechasService } from './validador-fechas.service';

describe('ValidadorFechasService', () => {
  let service: ValidadorFechasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ValidadorFechasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
