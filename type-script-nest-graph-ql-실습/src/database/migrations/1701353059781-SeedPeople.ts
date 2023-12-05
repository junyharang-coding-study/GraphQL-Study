import { MigrationInterface, QueryRunner, Table } from "typeorm";

export class SeedPeople1701353059781 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.createTable(
      new Table({
        name: "people",
        columns: [
          {
            name: "people_id",
            type: "integer",
            isPrimary: true,
            isGenerated: true,
            generationStrategy: "increment",
            comment: "ID",
          },

          { name: "team_id", type: "integer", isNullable: false, comment: "TEAM 번호" },
          { name: "last_name", type: "varchar", length: "255", isNullable: false, comment: "성" },
          { name: "first_name", type: "varchar", length: "255", isNullable: false, comment: "이름" },
          { name: "sex", type: "varchar", length: "255", isNullable: false, comment: "성별" },
          { name: "blood_type", type: "varchar", length: "255", isNullable: false, comment: "혈액형" },
          { name: "serve_years", type: "integer", isNullable: false, comment: "경력 년수" },
          { name: "role", type: "varchar", length: "255", isNullable: false, comment: "역할" },
          { name: "hometown", type: "varchar", length: "255", isNullable: false, comment: "출신지" },
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

    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (2, 'Alex', 'Davidson', 'male', 'O', 2, 'developer', 'California')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (3, 'Lindsay', 'West', 'female', 'A', 3, 'designer', 'Arizona')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (1, 'Nathan', 'Jenkins', 'male', 'B', 1, 'planner', 'Texas')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (4, 'Christine', 'Harris', 'female', 'B', 2, 'developer', 'Ohio')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (2,'Page','Adams','female','O', 5,'developer','California')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (5,'Herbert','Ford','male','A', 2,'designer','Messachusetts')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (2,'Dennis','Marshall','male','AB', 1,'planner','Colorado')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (1,'Isabella','Martin','female','A', 3,'developer','Georgia')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (4,'Alfred','Clarke','male','AB', 4,'designer','Pennsylvania')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (5,'Tyler','Philips','male','O', 1,'designer','Virginia')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (3,'Noelle','Holmes','female','AB', 5,'planner','California')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (1,'Kate','Owen','female','B', 2,'developer','Maine')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (4,'Priscilla','Walker','female','O', 2,'developer','California')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (3,'Shirley','Grant','female','AB', 1,'developer','Messachusetts')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (2,'Page','Adams','female','O', 5,'developer','California')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (1,'Byron','Barnes','male','A', 3,'designer','Idaho')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (3,'Toby','Lewis','male','A', 1,'planner','New York')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (4,'Barbara','White','female','AB', 4,'developer','Ohio')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (4,'Arnold','Armstrong','male','AB', 5,'designer','Nevada')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (2,'Eleanor','Smith','female','B', 2,'planner','Texas')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (5,'Nina','Dawson','female','O', 1,'developer','Virginia')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (3,'Jamie','Reynolds','male','AB', 1,'designer','Arizona')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (4,'Myrtle','Hamilton','female','O', 1,'developer','Maine')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (2,'Zelda','Hall','female','A', 3,'developer','Tennessee')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (4,'Edgar','Willson','male','AB', 2,'designer','Texas')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (4,'Naomi','Taylor','female','O', 5,'developer','Oklahoma')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (1,'Brian','Hunt','male','B', 2,'planner','Indiana')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (5,'Katherine','Bennett','female','A', 3,'designer','Utah')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (1,'Violet','Pearson','female','AB', 5,'designer','Pennsylvania')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (5,'Margaret','Davies','female','AB', 2,'developer','California')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (3,'Raymond','Cook','male','O', 1,'planner','Kansas')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (5,'Garth','Roberts','male','A', 4,'designer','Minnesota')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (2,'Victoria','Brown','female','B', 4,'planner','Georgia')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (3,'Russel','Jones','male','O', 2,'designer','Nebraska')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (1,'Sally','Fox','female','AB', 5,'planner','Messachusetts')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (4,'Chloe','Bailey','female','A', 5,'developer','New York')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (5,'Will','McDonald','male','AB', 1,'developer','Wyoming')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (3,'Grant','Cole','male','AB', 4,'designer','Pennsylvania')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (5,'Audrey','Fisher','female','O', 2,'designer','Ohio')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (3,'Amber','Russel','female','AB', 5,'developer','Kansas')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (4,'Peter','Payne','male','O', 3,'planner','California')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (1,'Russ','Lawrence','male','O', 5,'designer','New York')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (5,'Margot','Watson','female','AB', 2,'planner','Virginia')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (2,'Nancy','Brooks','female','A', 1,'developer','California')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (2,'Oliver','Simpson','male','O', 3,'designer','Arizona')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (3,'Pansy','Moore','female','B', 2,'planner','Minnesota')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (1,'Leroy','Elliott','male','AB', 2,'developer','Indiana')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (5,'Barbara','Murphy','female','O', 1,'developer','Texas')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (2,'Simon','Henderson','male','A', 4,'designer','Pennsylvania')`,
    );
    await queryRunner.query(
      `INSERT INTO \`people\` (\`team_id\`, \`last_name\`, \`first_name\`, \`sex\`, \`blood_type\`, \`serve_years\`,
                               \`role\`, \`hometown\`)
       VALUES (1,'Ned','Butler','male','O', 2,'planner','Messachusetts')`,
    );
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.dropTable("people");
  }
}
