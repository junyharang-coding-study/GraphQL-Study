import { Test, TestingModule } from "@nestjs/testing";
import { SoftwareResolver } from "./software.resolver";

describe("SoftwareResolverResolver", () => {
  let resolver: SoftwareResolver;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [SoftwareResolver],
    }).compile();

    resolver = module.get<SoftwareResolver>(SoftwareResolver);
  });

  it("should be defined", () => {
    expect(resolver).toBeDefined();
  });
});
