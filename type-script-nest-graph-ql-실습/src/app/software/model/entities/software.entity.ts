import { Column, Entity, PrimaryColumn, Unique } from "typeorm";
import { Field, InputType, ObjectType } from "@nestjs/graphql";

@InputType()
@ObjectType()
@Entity("software")
@Unique(["softwareId"])
export class SoftwareEntity {
  @Field(() => String)
  @PrimaryColumn("varchar", { name: "software_id", length: 255, nullable: false, comment: "ID" })
  softwareId: string;

  @Field(() => String)
  @Column("varchar", { name: "used_by", length: 255, nullable: false, comment: "사용자" })
  usedBy: string;

  @Field(() => String)
  @Column("varchar", { name: "developed_by", nullable: false, comment: "개발사" })
  developedBy: string;

  @Field(() => String)
  @Column("varchar", { name: "description", nullable: false, comment: "상세 정보" })
  description: string;
}
