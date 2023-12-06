import { Test, TestingModule } from "@nestjs/testing";
import { SoftwareServiceImpl } from "./software-service-impl.service";

describe("SoftwareServiceImplService", () => {
  let service: SoftwareServiceImpl;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [SoftwareServiceImpl],
    }).compile();

    service = module.get<SoftwareServiceImpl>(SoftwareServiceImpl);
  });

  it("should be defined", () => {
    expect(service).toBeDefined();
  });
});
