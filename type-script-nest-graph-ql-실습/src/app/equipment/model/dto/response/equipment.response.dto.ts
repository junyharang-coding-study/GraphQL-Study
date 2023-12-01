import { Equipment } from "../../entities/equipment";

export class EquipmentResponseDto {
  private equipmentId: string;
  private usedBy: string;
  private count: number;
  private newOrUsed: string;

  static toDto(equipment: Equipment): EquipmentResponseDto {
    const equipmentResponseDto = new EquipmentResponseDto();
    equipmentResponseDto.equipmentId = equipment.equipmentId;
    equipmentResponseDto.usedBy = equipment.usedBy;
    equipmentResponseDto.count = equipment.count;
    equipmentResponseDto.newOrUsed = equipment.newOrUsed;
    return equipmentResponseDto;
  }
}
