import { Seeder } from "typeorm-extension";
import { DataSource } from "typeorm";
import { RoleEntity } from "../../app/role/model/entities/role.entity";

export default class RoleSeeder implements Seeder {
  async run(dataSource: DataSource): Promise<any> {
    const repository = dataSource.getRepository(RoleEntity);

    await repository.insert([
      {
        roleId: "developer",
        job: "programming",
        requirement: "computer science degree",
      },
    ]);

    await repository.insert([
      {
        roleId: "designer",
        job: "web design",
        requirement: "graphic design certificate",
      },
    ]);

    await repository.insert([
      {
        roleId: "planner",
        job: "service planning",
        requirement: "portfolio",
      },
    ]);
  }
}
