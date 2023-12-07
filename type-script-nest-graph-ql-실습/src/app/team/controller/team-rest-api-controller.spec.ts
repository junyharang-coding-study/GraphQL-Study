import { Test, TestingModule } from "@nestjs/testing";
import { TeamRestApiController } from "./team-rest-api.controller";

describe("TeamRestApiControllerController", () => {
  let controller: TeamRestApiController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [TeamRestApiController],
    }).compile();

    controller = module.get<TeamRestApiController>(TeamRestApiController);
  });

  it("should be defined", () => {
    expect(controller).toBeDefined();
  });
});
