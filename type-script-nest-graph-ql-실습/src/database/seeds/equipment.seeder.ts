import { Seeder } from "typeorm-extension";
import { DataSource } from "typeorm";
import { EquipmentEntity } from "../../app/equipment/model/entities/equipment.entity";

export default class EquipmentSeeder implements Seeder {
  async run(dataSource: DataSource): Promise<any> {
    const repository = dataSource.getRepository(EquipmentEntity);

    await repository.insert([
      {
        equipmentId: "machanical keyboard",
        usedBy: "developer",
        count: 24,
        newOrUsed: "used",
      },
    ]);

    await repository.insert([
      {
        equipmentId: "pen tablet",
        usedBy: "developer",
        count: 15,
        newOrUsed: "used",
      },
    ]);

    await repository.insert([
      {
        equipmentId: "notebook",
        usedBy: "planner",
        count: 37,
        newOrUsed: "new",
      },
    ]);

    await repository.insert([
      {
        equipmentId: "ergonomic mouse",
        usedBy: "designer",
        count: 31,
        newOrUsed: "used",
      },
    ]);

    await repository.insert([
      {
        equipmentId: "dual monitor",
        usedBy: "developer",
        count: 20,
        newOrUsed: "used",
      },
    ]);

    await repository.insert([
      {
        equipmentId: "whiteboard",
        usedBy: "planner",
        count: 12,
        newOrUsed: "used",
      },
    ]);

    await repository.insert([
      {
        equipmentId: "sketchb",
        usedBy: "designer",
        count: 48,
        newOrUsed: "new",
      },
    ]);
  }
}
