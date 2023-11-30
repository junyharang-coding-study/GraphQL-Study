import { MigrationInterface, QueryRunner, Table } from "typeorm";

export class SeedSoftware1701353069428 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.createTable(
      new Table({
        name: "software",
        columns: [
          {
            name: "software_id",
            type: "varchar",
            length: "255",
            isPrimary: true,
            isNullable: false,
            comment: "ID",
          },

          { name: "used_by", type: "varchar", length: "255", isNullable: false, comment: "사용자" },
          { name: "developed_by", type: "varchar", length: "255", isNullable: false, comment: "개발사" },
          { name: "description", type: "varchar", length: "255", isNullable: false, comment: "상세 정보" },
        ],
      }),
      true,
    );

    await queryRunner.query(`INSERT INTO \`software\` (\`software_id\`, \`used_by\`, \`developed_by\`, \`description\`)
                             VALUES ('Eclipse', 'developer', 'Eclipse Foundation', 'integrated development environment')`);
    await queryRunner.query(`INSERT INTO \`software\` (\`software_id\`, \`used_by\`, \`developed_by\`, \`description\`)
                             VALUES ('Excel', 'planner', 'Microsoft', 'spreadsheet')`);
    await queryRunner.query(`INSERT INTO \`software\` (\`software_id\`, \`used_by\`, \`developed_by\`, \`description\`)
                             VALUES ('Illustrator', 'designer', 'Adobe', 'vector graphics editor')`);
    await queryRunner.query(`INSERT INTO \`software\` (\`software_id\`, \`used_by\`, \`developed_by\`, \`description\`)
                             VALUES ('Photoshop', 'designer', 'Adobe', 'raster graphics editor')`);
    await queryRunner.query(`INSERT INTO \`software\` (\`software_id\`, \`used_by\`, \`developed_by\`, \`description\`)
                             VALUES ('PowerPoint', 'planner', 'Microsoft', 'presentation program')`);
    await queryRunner.query(`INSERT INTO \`software\` (\`software_id\`, \`used_by\`, \`developed_by\`, \`description\`)
                             VALUES ('Sketch', 'designer', 'Sketch B.V.', 'vector graphics editor')`);
    await queryRunner.query(`INSERT INTO \`software\` (\`software_id\`, \`used_by\`, \`developed_by\`, \`description\`)
                             VALUES ('VS Code', 'developer', 'Microsoft', 'source code editor')`);
    await queryRunner.query(`INSERT INTO \`software\` (\`software_id\`, \`used_by\`, \`developed_by\`, \`description\`)
                             VALUES ('Word', 'planner', 'Microsoft', 'word processor')`);
    await queryRunner.query(`INSERT INTO \`software\` (\`software_id\`, \`used_by\`, \`developed_by\`, \`description\`)
                             VALUES ('Xcode', 'developer', 'Apple', 'integrated development environment')`);
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.dropTable("software");
  }
}
