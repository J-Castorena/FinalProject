import { TestBed } from '@angular/core/testing';

import { DateNightDiscussionBoardService } from './date-night-discussion-board.service';

describe('DateNightDiscussionBoardService', () => {
  let service: DateNightDiscussionBoardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DateNightDiscussionBoardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
