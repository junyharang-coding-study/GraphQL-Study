import { EquipmentEntity } from "../../entities/equipment.entity";

export class EquipmentResponseDto {
  private equipmentId: string;
  private usedBy: string;
  private count: number;
  private newOrUsed: string;

  static toDto(equipment: EquipmentEntity): EquipmentResponseDto {
    const equipmentResponseDto = new EquipmentResponseDto();
    equipmentResponseDto.equipmentId = equipment.equipmentId;
    equipmentResponseDto.usedBy = equipment.usedBy;
    equipmentResponseDto.count = equipment.count;
    equipmentResponseDto.newOrUsed = equipment.newOrUsed;
    return equipmentResponseDto;
  }
}
