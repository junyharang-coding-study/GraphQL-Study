import { Test, TestingModule } from "@nestjs/testing";
import { SupplyServiceImpl } from "./supply-service-impl.service";

describe("SupplyServiceImplService", () => {
  let service: SupplyServiceImpl;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [SupplyServiceImpl],
    }).compile();

    service = module.get<SupplyServiceImpl>(SupplyServiceImpl);
  });

  it("should be defined", () => {
    expect(service).toBeDefined();
  });
});
