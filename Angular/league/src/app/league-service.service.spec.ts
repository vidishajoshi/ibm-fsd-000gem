import { TestBed } from '@angular/core/testing';

import { LeagueServiceService } from './league-service.service';

describe('LeagueServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LeagueServiceService = TestBed.get(LeagueServiceService);
    expect(service).toBeTruthy();
  });
});
