import { TestBed } from '@angular/core/testing';

import { DateNightService } from './date-night.service';

describe('DateNightService', () => {
  let service: DateNightService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DateNightService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
