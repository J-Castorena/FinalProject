import { TestBed } from '@angular/core/testing';

import { AdditionalImageService } from './additional-image.service';

describe('AdditionalImageService', () => {
  let service: AdditionalImageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdditionalImageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
