import { Column, Entity, PrimaryColumn, Unique } from "typeorm";
import { Field, InputType, ObjectType } from "@nestjs/graphql";

@InputType()
@ObjectType()
@Entity("role")
@Unique(["roleId"])
export class RoleEntity {
  @Field(() => String)
  @PrimaryColumn("varchar", { name: "role_id", length: 255, nullable: false, comment: "ID" })
  roleId: string;

  @Field(() => String)
  @Column("varchar", { name: "job", length: 255, nullable: false, comment: "구분" })
  job: string;

  @Field(() => String)
  @Column("varchar", { name: "requirement", nullable: false })
  requirement: string;
}
