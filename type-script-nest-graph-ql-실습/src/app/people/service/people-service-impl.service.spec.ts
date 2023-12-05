import { Test, TestingModule } from "@nestjs/testing";
import { PeopleServiceImpl } from "./people-service-impl.service";

describe("PeopleServiceImplService", () => {
  let service: PeopleServiceImpl;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [PeopleServiceImpl],
    }).compile();

    service = module.get<PeopleServiceImpl>(PeopleServiceImpl);
  });

  it("should be defined", () => {
    expect(service).toBeDefined();
  });
});
