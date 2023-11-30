import { MigrationInterface, QueryRunner, Table } from "typeorm";

export class SeedRole1701353063922 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.createTable(
      new Table({
        name: "role",
        columns: [
          {
            name: "role_id",
            type: "varchar",
            length: "255",
            isPrimary: true,
            isNullable: false,
            comment: "ID",
          },

          { name: "job", type: "varchar", length: "255", isNullable: false, comment: "구분" },
          { name: "requirement", type: "varchar", length: "255", isNullable: false },
        ],
      }),
      true,
    );

    await queryRunner.query(`INSERT INTO \`role\` (\`role_id\`, \`job\`, \`requirement\`)
                             VALUES ('developer', 'programming', 'computer science degree')`);
    await queryRunner.query(`INSERT INTO \`role\` (\`role_id\`, \`job\`, \`requirement\`)
                             VALUES ('designer', 'web design', 'graphic design certificate')`);
    await queryRunner.query(`INSERT INTO \`role\` (\`role_id\`, \`job\`, \`requirement\`)
                             VALUES ('planner', 'service planning', 'portfolio')`);
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.dropTable("role");
  }
}
