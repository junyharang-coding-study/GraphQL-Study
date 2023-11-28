import { Column, Entity, PrimaryGeneratedColumn, Unique } from "typeorm";

@Entity("team")
@Unique(["teamId"])
export class TeamEntity {
  @PrimaryGeneratedColumn()
  teamId: number;

  @Column("varchar", { name: "manager", length: 255, nullable: false })
  manager: string;

  @Column("varchar", { name: "office", length: 5, nullable: false, comment: "사무실 호수" })
  office: string;

  @Column("varchar", { name: "extension_number", length: 5, nullable: false, comment: "팀 관리자" })
  extensionNumber: string;

  @Column("varchar", { name: "mascot", length: 10, nullable: true, comment: "마스코트" })
  mascot: string;

  @Column("varchar", { name: "cleaning_duty", length: 10, nullable: false, comment: "청소 당번 요일" })
  cleaningDuty: string;

  @Column("varchar", { name: "project", length: 10, nullable: false, comment: "프로젝트 명" })
  project: string;
}
