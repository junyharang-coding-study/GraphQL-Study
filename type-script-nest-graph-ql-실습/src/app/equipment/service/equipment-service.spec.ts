import { Test, TestingModule } from "@nestjs/testing";
import { EquipmentImplService } from "./equipment-Impl.service";

describe("EquipmentServiceImplService", () => {
  let service: EquipmentImplService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [EquipmentImplService],
    }).compile();

    service = module.get<EquipmentImplService>(EquipmentImplService);
  });

  it("should be defined", () => {
    expect(service).toBeDefined();
  });
});
