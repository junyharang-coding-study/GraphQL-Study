import { Column, Entity, JoinColumn, ManyToOne, PrimaryGeneratedColumn, Unique } from "typeorm";
import { Sex } from "../../../../common/enum/people.sex.enum";
import { Role } from "../../../../common/enum/people.role.enum";
import { BloodType } from "../../../../common/enum/people.blood-type.enum";
import { TeamEntity } from "../../../team/model/entities/team.entity";

@Entity("people")
@Unique(["peopleId"])
export class PeopleEntity {
  @PrimaryGeneratedColumn({ name: "people_id" })
  peopleId: number;

  @ManyToOne(() => TeamEntity)
  @JoinColumn({ name: "team_id" })
  team: Promise<TeamEntity>;

  @Column("varchar", { name: "last_name", length: 255, nullable: false, comment: "성" })
  lastName: string;

  @Column("varchar", { name: "first_name", length: 255, nullable: false, comment: "이름" })
  firstName: string;

  @Column("varchar", { name: "sex", length: 6, nullable: false, comment: "이름" })
  sex: Sex;

  @Column("varchar", { name: "blood_type", length: 2, nullable: false, comment: "이름" })
  bloodType: BloodType;

  @Column("int", { name: "serveYears", nullable: false, comment: "이름" })
  serveYears: number;

  @Column("varchar", { name: "role", length: 100, nullable: false, comment: "역할" })
  role: Role;

  @Column("varchar", { name: "hometown", nullable: false, comment: "출신지" })
  hometown: string;
}
