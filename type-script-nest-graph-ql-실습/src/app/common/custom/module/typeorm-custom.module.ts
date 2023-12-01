import { DynamicModule, Provider } from "@nestjs/common";
import { TypeormRepository } from "../decorator/typeorm-repository.decorator";
import { getDataSourceToken } from "@nestjs/typeorm";
import { DataSource } from "typeorm";

export class TypeormCustomModule {
  public static forCustomRepository<T extends new (...args: any[]) => any>(repositories: T[]): DynamicModule {
    const providers: Provider[] = [];

    for (const repository of repositories) {
      const entity = Reflect.getMetadata(TypeormRepository, repository);

      if (!entity) {
        continue;
      }

      providers.push({
        inject: [getDataSourceToken()],
        provide: repository,
        useFactory: (dataSource: DataSource): typeof repository => {
          const baseRepository = dataSource.getRepository<T>(entity);
          return new repository(baseRepository.target, baseRepository.manager, baseRepository.queryRunner);
        },
      });
    }

    return { exports: providers, module: TypeormCustomModule, providers };
  }
}
