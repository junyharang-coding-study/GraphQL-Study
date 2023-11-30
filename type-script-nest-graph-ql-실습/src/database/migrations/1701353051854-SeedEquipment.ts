import { MigrationInterface, QueryRunner, Table } from "typeorm";

export class SeedEquipment1701353051854 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.createTable(
      new Table({
        name: "equipment",
        columns: [
          {
            name: "equipment_id",
            type: "varchar",
            length: "255",
            isPrimary: true,
            isNullable: false,
            comment: "ID",
          },

          {
            name: "used_by",
            type: "varchar",
            length: "255",
            isNullable: false,
            comment: "사용자",
          },

          { name: "count", type: "integer", isNullable: false, comment: "수량" },
          { name: "new_or_used", type: "varchar", length: "10", isNullable: false },
        ],
      }),
      true,
    );

    await queryRunner.query(`INSERT INTO \`equipment\` (\`equipment_id\`, \`used_by\`, \`count\`, \`new_or_used\`)
                             VALUES ('machanical keyboard', 'developer', 24, 'used')`);
    await queryRunner.query(`INSERT INTO \`equipment\` (\`equipment_id\`, \`used_by\`, \`count\`, \`new_or_used\`)
                             VALUES ('pen tablet', 'developer', 15, 'used')`);
    await queryRunner.query(`INSERT INTO \`equipment\` (\`equipment_id\`, \`used_by\`, \`count\`, \`new_or_used\`)
                             VALUES ('ergonomic mouse', 'designer', 31, 'used')`);
    await queryRunner.query(`INSERT INTO \`equipment\` (\`equipment_id\`, \`used_by\`, \`count\`, \`new_or_used\`)
                             VALUES ('dual monitor', 'developer', 20, 'used')`);
    await queryRunner.query(`INSERT INTO \`equipment\` (\`equipment_id\`, \`used_by\`, \`count\`, \`new_or_used\`)
                             VALUES ('whiteboard', 'planner', 12, 'used')`);
    await queryRunner.query(`INSERT INTO \`equipment\` (\`equipment_id\`, \`used_by\`, \`count\`, \`new_or_used\`)
                             VALUES ('sketchb', 'designer', 48, 'new')`);
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.dropTable("equipment");
  }
}
