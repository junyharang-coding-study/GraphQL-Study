import { MigrationInterface, QueryRunner, Table } from "typeorm";

export class SeedSupply1701325299045 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.createTable(
      new Table({
        name: "supply",
        columns: [
          {
            name: "supply_id",
            type: "varchar",
            length: "255",
            isPrimary: true,
            isNullable: false,
            comment: "ID",
          },

          { name: "team_id", type: "integer", isNullable: false, comment: "TEAM 번호" },
        ],
        foreignKeys: [
          {
            columnNames: ["team_id"],
            referencedTableName: "team",
            referencedColumnNames: ["team_id"],
            onDelete: "CASCADE",
          },
        ],
      }),
      true,
    );

    //Seeding Data 삽입
    await queryRunner.query(`INSERT INTO \`supply\` (\`supply_id\`, \`team_id\`)
                             VALUES ('ergonomic mouse', 1)`);
    await queryRunner.query(`INSERT INTO \`supply\` (\`supply_id\`, \`team_id\`)
                             VALUES ('mug', 1)`);
    await queryRunner.query(`INSERT INTO \`supply\` (\`supply_id\`, \`team_id\`)
                             VALUES ('webcam', 2)`);
    await queryRunner.query(`INSERT INTO \`supply\` (\`supply_id\`, \`team_id\`)
                             VALUES ('hoodie', 2)`);
    await queryRunner.query(`INSERT INTO \`supply\` (\`supply_id\`, \`team_id\`)
                             VALUES ('chair', 3)`);
    await queryRunner.query(`INSERT INTO \`supply\` (\`supply_id\`, \`team_id\`)
                             VALUES ('usb hub', 3)`);
    await queryRunner.query(`INSERT INTO \`supply\` (\`supply_id\`, \`team_id\`)
                             VALUES ('headphone', 4)`);
    await queryRunner.query(`INSERT INTO \`supply\` (\`supply_id\`, \`team_id\`)
                             VALUES ('stempler', 4)`);
    await queryRunner.query(`INSERT INTO \`supply\` (\`supply_id\`, \`team_id\`)
                             VALUES ('calculator', 5)`);
    await queryRunner.query(`INSERT INTO \`supply\` (\`supply_id\`, \`team_id\`)
                             VALUES ('t shirt', 5)`);
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.dropTable("supply");
  }
}
