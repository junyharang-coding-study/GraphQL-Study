import { Column, Entity, PrimaryGeneratedColumn } from "typeorm";
import { Field, ObjectType } from "@nestjs/graphql";

@ObjectType()
@Entity("team")
// @Unique(["teamId"])
export class TeamEntity {
  @Field(() => Number)
  @PrimaryGeneratedColumn({ name: "team_id" })
  teamId: number;

  @Field(() => String)
  @Column("varchar", { name: "manager", length: 255, nullable: false })
  manager: string;

  @Field(() => String)
  @Column("varchar", { name: "office", length: 5, nullable: false, comment: "사무실 호수" })
  office: string;

  @Field(() => String)
  @Column("varchar", { name: "extension_number", length: 5, nullable: false, comment: "팀 관리자" })
  extensionNumber: string;

  @Field(() => String)
  @Column("varchar", { name: "mascot", length: 10, nullable: true, comment: "마스코트" })
  mascot: string;

  @Field(() => String)
  @Column("varchar", { name: "cleaning_duty", length: 10, nullable: false, comment: "청소 당번 요일" })
  cleaningDuty: string;

  @Field(() => String)
  @Column("varchar", { name: "project", length: 10, nullable: false, comment: "프로젝트 명" })
  project: string;
}
