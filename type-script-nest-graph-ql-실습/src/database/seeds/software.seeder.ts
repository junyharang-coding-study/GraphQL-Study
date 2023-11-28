import { Seeder } from "typeorm-extension";
import { DataSource } from "typeorm";
import { SoftwareEntity } from "../../app/software/model/entities/software.entity";

export default class SoftwareSeeder implements Seeder {
  async run(dataSource: DataSource): Promise<any> {
    const repository = dataSource.getRepository(SoftwareEntity);

    await repository.insert([
      {
        softwareId: "Eclipse",
        usedBy: "developer",
        developedBy: "Eclipse Foundation",
        description: "integrated development environment",
      },
    ]);

    await repository.insert([
      {
        softwareId: "Excel",
        usedBy: "planner",
        developedBy: "Microsoft",
        description: "spreadsheet",
      },
    ]);

    await repository.insert([
      {
        softwareId: "Illustrator",
        usedBy: "designer",
        developedBy: "Adobe",
        description: "vector graphics editor",
      },
    ]);

    await repository.insert([
      {
        softwareId: "Photoshop",
        usedBy: "designer",
        developedBy: "Adobe",
        description: "raster graphics editor",
      },
    ]);

    await repository.insert([
      {
        softwareId: "PowerPoint",
        usedBy: "planner",
        developedBy: "Microsoft",
        description: "presentation program",
      },
    ]);

    await repository.insert([
      {
        softwareId: "Sketch",
        usedBy: "designer",
        developedBy: "Sketch B.V.",
        description: "vector graphics editor",
      },
    ]);

    await repository.insert([
      {
        softwareId: "VS Code",
        usedBy: "developer",
        developedBy: "Microsoft",
        description: "source code editor",
      },
    ]);

    await repository.insert([
      {
        softwareId: "Word",
        usedBy: "planner",
        developedBy: "Microsoft",
        description: "word processor",
      },
    ]);

    await repository.insert([
      {
        softwareId: "Xcode",
        usedBy: "developer",
        developedBy: "Apple",
        description: "integrated development environment",
      },
    ]);
  }
}
