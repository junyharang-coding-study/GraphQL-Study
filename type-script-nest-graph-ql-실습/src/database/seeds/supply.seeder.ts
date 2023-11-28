import { Seeder } from "typeorm-extension";
import { DataSource } from "typeorm";
import { SupplyEntity } from "../../app/supply/model/entities/supply.entity";
import { TeamEntity } from "../../app/team/model/entities/team.entity";

export default class SupplySeeder implements Seeder {
  async run(dataSource: DataSource): Promise<any> {
    const repository = dataSource.getRepository(SupplyEntity);

    await repository.insert([
      {
        supplyId: "ergonomic mouse",
        team: Promise.resolve(dataSource.getRepository(TeamEntity).findOneById(1)),
      },
    ]);

    await repository.insert([
      {
        supplyId: "mug",
        team: Promise.resolve(dataSource.getRepository(TeamEntity).findOneById(2)),
      },
    ]);

    await repository.insert([
      {
        supplyId: "webcam",
        team: Promise.resolve(dataSource.getRepository(TeamEntity).findOneById(2)),
      },
    ]);

    await repository.insert([
      {
        supplyId: "hoodie",
        team: Promise.resolve(dataSource.getRepository(TeamEntity).findOneById(3)),
      },
    ]);

    await repository.insert([
      {
        supplyId: "chair",
        team: Promise.resolve(dataSource.getRepository(TeamEntity).findOneById(3)),
      },
    ]);

    await repository.insert([
      {
        supplyId: "usb hub",
        team: Promise.resolve(dataSource.getRepository(TeamEntity).findOneById(4)),
      },
    ]);

    await repository.insert([
      {
        supplyId: "headphone",
        team: Promise.resolve(dataSource.getRepository(TeamEntity).findOneById(4)),
      },
    ]);

    await repository.insert([
      {
        supplyId: "stempler",
        team: Promise.resolve(dataSource.getRepository(TeamEntity).findOneById(4)),
      },
    ]);

    await repository.insert([
      {
        supplyId: "calculator",
        team: Promise.resolve(dataSource.getRepository(TeamEntity).findOneById(5)),
      },
    ]);

    await repository.insert([
      {
        supplyId: "t shirt",
        team: Promise.resolve(dataSource.getRepository(TeamEntity).findOneById(5)),
      },
    ]);
  }
}
