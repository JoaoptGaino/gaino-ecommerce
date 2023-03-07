import { TestBed } from '@angular/core/testing';

import { GainoShopFormService } from './gaino-shop-form.service';

describe('GainoShopFormService', () => {
  let service: GainoShopFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GainoShopFormService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
