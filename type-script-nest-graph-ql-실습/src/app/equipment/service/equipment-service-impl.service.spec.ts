import { Test, TestingModule } from "@nestjs/testing";
import { EquipmentServiceImpl } from "./equipment-service-impl";

describe("EquipmentServiceImplService", () => {
  let service: EquipmentServiceImpl;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [EquipmentServiceImpl],
    }).compile();

    service = module.get<EquipmentServiceImpl>(EquipmentServiceImpl);
  });

  it("should be defined", () => {
    expect(service).toBeDefined();
  });
});
