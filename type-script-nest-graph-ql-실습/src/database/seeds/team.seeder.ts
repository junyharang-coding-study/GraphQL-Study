import { Seeder } from "typeorm-extension";
import { DataSource } from "typeorm";
import { TeamEntity } from "../../app/team/model/entities/team.entity";

export default class TeamSeeder implements Seeder {
  async run(dataSource: DataSource): Promise<any> {
    const repository = dataSource.getRepository(TeamEntity);

    await repository.insert([
      {
        manager: "Mandy Warren",
        office: "101A",
        extensionNumber: "#5709",
        mascot: "Panda",
        cleaningDuty: "Monday",
        project: "Hyperion",
      },
    ]);

    await repository.insert([
      {
        manager: "Stewart Grant",
        office: "101B",
        extensionNumber: "#4012",
        mascot: "Tadpole",
        cleaningDuty: "Tuesday",
        project: "Zen",
      },
    ]);

    await repository.insert([
      {
        manager: "Smantha Wheatly",
        office: "102A",
        extensionNumber: "#3852",
        mascot: "Falcon",
        cleaningDuty: "Wednesday",
        project: "Duranno",
      },
    ]);

    await repository.insert([
      {
        manager: "Francis Buckley",
        office: "103B",
        extensionNumber: "#1039",
        mascot: "Beaver",
        cleaningDuty: "Thursday",
        project: "Genghis",
      },
    ]);

    await repository.insert([
      {
        manager: "Blake Smith",
        office: "104A",
        extensionNumber: "#7750",
        mascot: "Wildcat",
        cleaningDuty: "Friday",
        project: "Acheron",
      },
    ]);
  }
}
