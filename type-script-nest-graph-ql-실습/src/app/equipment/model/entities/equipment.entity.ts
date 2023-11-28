import { Column, Entity, PrimaryColumn, Unique } from "typeorm";

@Entity("equipment")
@Unique(["equipmentId"])
export class EquipmentEntity {
  @PrimaryColumn("varchar", { name: "equipment_id", length: 255, nullable: false, comment: "ID" })
  equipmentId: string;

  @Column("varchar", { name: "used_by", length: 255, nullable: false, comment: "사용자" })
  usedBy: string;

  @Column("int", { name: "count", nullable: false, comment: "수량" })
  count: number;

  @Column("varchar", { name: "new_or_used", length: 10, nullable: false })
  newOrUsed: string;
}
