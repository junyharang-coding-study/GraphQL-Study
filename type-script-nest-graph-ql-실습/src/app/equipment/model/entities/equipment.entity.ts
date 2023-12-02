import { Column, Entity, PrimaryColumn, Unique } from "typeorm";
import { Field, ObjectType } from "@nestjs/graphql";

@ObjectType()
@Entity("equipment")
@Unique(["equipmentId"])
export class EquipmentEntity {
  @Field(() => String)
  @PrimaryColumn("varchar", { name: "equipment_id", length: 255, nullable: false, comment: "ID" })
  equipmentId: string;

  @Field(() => String)
  @Column("varchar", { name: "used_by", length: 255, nullable: false, comment: "사용자" })
  usedBy: string;

  @Field(() => Number)
  @Column("int", { name: "count", nullable: false, comment: "수량" })
  count: number;

  @Field(() => String)
  @Column("varchar", { name: "new_or_used", length: 10, nullable: false })
  newOrUsed: string;
}
