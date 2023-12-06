import { Test, TestingModule } from "@nestjs/testing";
import { RoleServiceImpl } from "./role-service-impl.service";

describe("RoleService", () => {
  let service: RoleServiceImpl;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [RoleServiceImpl],
    }).compile();

    service = module.get<RoleServiceImpl>(RoleServiceImpl);
  });

  it("should be defined", () => {
    expect(service).toBeDefined();
  });
});
