import { MigrationInterface, QueryRunner, Table } from "typeorm";

export class SeedTeam1701325303468 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    const teamTableExist = await queryRunner.hasTable("team");

    if (!teamTableExist) {
      await queryRunner.createTable(
        new Table({
          name: "team",
          columns: [
            {
              name: "team_id",
              type: "integer",
              isPrimary: true,
              isGenerated: true,
              generationStrategy: "increment",
              comment: "ID",
            },

            {
              name: "manager",
              type: "varchar",
              length: "255",
              isNullable: false,
              comment: "팀 관리자",
            },

            {
              name: "office",
              type: "varchar",
              length: "5",
              isNullable: false,
              comment: "사무실 호수",
            },

            {
              name: "extension_number",
              type: "varchar",
              length: "5",
              isNullable: false,
              comment: "내선 번호",
            },

            {
              name: "mascot",
              type: "varchar",
              length: "10",
              isNullable: true,
              comment: "마스코트",
            },

            {
              name: "cleaning_duty",
              type: "varchar",
              length: "10",
              isNullable: false,
              comment: "청소 당번 요일",
            },

            {
              name: "project",
              type: "varchar",
              length: "10",
              isNullable: true,
              comment: "프로젝트 명",
            },
          ],
        }),
        true,
      );
    }

    //Seeding Data 삽입
    await queryRunner.query(
      `INSERT INTO \`team\` (\`manager\`, \`office\`, \`extension_number\`, \`mascot\`, \`cleaning_duty\`, \`project\`)
       VALUES ('Mandy Warren', '101A', '#5709', 'Panda', 'Monday', 'Hyperion')`,
    );
    await queryRunner.query(
      `INSERT INTO \`team\` (\`manager\`, \`office\`, \`extension_number\`, \`mascot\`, \`cleaning_duty\`, \`project\`)
       VALUES ('Stewart Grant', '101B', '#4012', 'Tadpole', 'Tuesday', 'Zen')`,
    );
    await queryRunner.query(
      `INSERT INTO \`team\` (\`manager\`, \`office\`, \`extension_number\`, \`mascot\`, \`cleaning_duty\`, \`project\`)
       VALUES ('Smantha Wheatly', '102A', '#3852', 'Falcon', 'Wednesday', 'Duranno')`,
    );
    await queryRunner.query(
      `INSERT INTO \`team\` (\`manager\`, \`office\`, \`extension_number\`, \`mascot\`, \`cleaning_duty\`, \`project\`)
       VALUES ('Francis Buckley', '103B', '#1039', 'Beaver', 'Thursday', 'Genghis')`,
    );
    await queryRunner.query(
      `INSERT INTO \`team\` (\`manager\`, \`office\`, \`extension_number\`, \`mascot\`, \`cleaning_duty\`, \`project\`)
       VALUES ('Blake Smith', '104A', '#7750', 'Wildcat', 'Friday', 'Acheron')`,
    );
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.dropTable("team");
  }
}
