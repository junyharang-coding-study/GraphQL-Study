import { Test, TestingModule } from "@nestjs/testing";
import { EquipmentService } from "./equipment.service";

describe("EquipmentServiceImplService", () => {
  let service: EquipmentService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [EquipmentService],
    }).compile();

    service = module.get<EquipmentService>(EquipmentService);
  });

  it("should be defined", () => {
    expect(service).toBeDefined();
  });
});
