import { Column, Entity, JoinColumn, ManyToOne, PrimaryGeneratedColumn, Unique } from "typeorm";
import { Sex } from "../../../../common/enum/people.sex.enum";
import { Role } from "../../../../common/enum/people.role.enum";
import { BloodType } from "../../../../common/enum/people.blood-type.enum";
import { TeamEntity } from "../../../team/model/entities/team.entity";
import { Field, ObjectType } from "@nestjs/graphql";

@ObjectType()
@Entity("people")
@Unique(["peopleId"])
export class PeopleEntity {
  @Field(() => Number)
  @PrimaryGeneratedColumn({ name: "people_id" })
  peopleId: number;

  @Field(() => TeamEntity)
  @ManyToOne(() => TeamEntity, { onDelete: "CASCADE" })
  @JoinColumn({ name: "team_id" })
  team: TeamEntity;

  @Field(() => String)
  @Column("varchar", { name: "last_name", length: 255, nullable: false, comment: "성" })
  lastName: string;

  @Field(() => String)
  @Column("varchar", { name: "first_name", length: 255, nullable: false, comment: "이름" })
  firstName: string;

  @Field(() => Sex)
  @Column("varchar", { name: "sex", length: 6, nullable: false, comment: "성별" })
  sex: Sex;

  @Field(() => BloodType)
  @Column("varchar", { name: "blood_type", length: 2, nullable: false, comment: "혈액형" })
  bloodType: BloodType;

  @Field(() => Number)
  @Column("int", { name: "serve_years", nullable: false, comment: "경력 년수" })
  serveYears: number;

  @Field(() => Role)
  @Column("varchar", { name: "role", length: 100, nullable: false, comment: "역할" })
  role: Role;

  @Field(() => String)
  @Column("varchar", { name: "hometown", nullable: false, comment: "출신지" })
  hometown: string;
}
