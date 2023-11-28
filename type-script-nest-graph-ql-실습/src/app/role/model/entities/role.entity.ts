import { Column, Entity, PrimaryColumn, Unique } from "typeorm";

@Entity("role")
@Unique(["roleId"])
export class RoleEntity {
  @PrimaryColumn("varchar", { name: "role_id", length: 255, nullable: false, comment: "ID" })
  roleId: string;

  @Column("varchar", { name: "job", length: 255, nullable: false, comment: "구분" })
  job: string;

  @Column("varchar", { name: "requirement", nullable: false })
  requirement: string;
}
