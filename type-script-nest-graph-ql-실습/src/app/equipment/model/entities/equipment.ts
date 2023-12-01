import { Column, Entity, PrimaryColumn, Unique } from "typeorm";
import { EquipmentRequestDto } from "../dto/request/equipment-request.dto";

@Entity("equipment")
@Unique(["equipmentId"])
export class Equipment {
  @PrimaryColumn("varchar", { name: "equipment_id", length: 255, nullable: false, comment: "ID" })
  equipmentId!: string;

  @Column("varchar", { name: "used_by", length: 255, nullable: false, comment: "사용자" })
  usedBy!: string;

  @Column("int", { name: "count", nullable: false, comment: "수량" })
  count!: number;

  @Column("varchar", { name: "new_or_used", length: 10, nullable: false })
  newOrUsed!: string;

  static toEntity(equipmentRequestDto: EquipmentRequestDto): Equipment {
    const equipment = new Equipment();
    equipment.equipmentId = equipmentRequestDto.equipmentId;
    equipment.usedBy = equipmentRequestDto.usedBy;
    equipment.count = equipmentRequestDto.count;
    equipment.newOrUsed = equipmentRequestDto.newOrUsed;
    return equipment;
  }
}
