import { EquipmentEntity } from "../../entities/equipment.entity";

export class EquipmentAdvResponseDto {
  private equipmentId: string;
  private usedBy: string;
  private count: number;
  private newOrUsed: string;
  private useRate: number;
  private isNew: boolean;

  constructor(equipment: EquipmentEntity) {
    this.equipmentId = equipment.equipmentId;
    this.usedBy = equipment.usedBy;
    this.count = equipment.count;
    this.newOrUsed = equipment.newOrUsed;

    if (equipment.usedBy === "developer") {
      this.useRate = Number(Math.random().toFixed(2));
    }

    this.isNew = equipment.newOrUsed === "new";
  }
}
