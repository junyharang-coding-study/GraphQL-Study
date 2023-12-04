import { EquipmentEntity } from "../../entities/equipment.entity";

export class EquipmentResponseDto {
  private equipmentId: string;
  private usedBy: string;
  private count: number;
  private newOrUsed: string;

  constructor(entity: EquipmentEntity) {
    this.equipmentId = entity.equipmentId;
    this.usedBy = entity.usedBy;
    this.count = entity.count;
    this.newOrUsed = entity.newOrUsed;
  }
}
