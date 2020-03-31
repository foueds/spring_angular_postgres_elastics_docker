import { TestBed } from '@angular/core/testing';

import { InvokerService } from './invoker.service';

describe('InvokerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: InvokerService = TestBed.get(InvokerService);
    expect(service).toBeTruthy();
  });
});
