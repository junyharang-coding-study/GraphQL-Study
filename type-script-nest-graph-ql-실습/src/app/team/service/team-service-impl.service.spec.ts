import { Test, TestingModule } from "@nestjs/testing";
import { TeamImplService } from "./team-impl.service";

describe("TeamServiceImplService", () => {
  let service: TeamImplService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [TeamImplService],
    }).compile();

    service = module.get<TeamImplService>(TeamImplService);
  });

  it("should be defined", () => {
    expect(service).toBeDefined();
  });
});
