import { TestBed } from '@angular/core/testing';

import { GtestGuard } from './gtest.guard';

describe('GtestGuard', () => {
  let guard: GtestGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(GtestGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
