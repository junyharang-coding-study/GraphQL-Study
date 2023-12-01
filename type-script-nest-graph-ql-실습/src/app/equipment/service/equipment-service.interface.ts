import { EquipmentResponseDto } from "../model/dto/response/equipment.response.dto";
import { DefaultResponse } from "../../common/constant/default.response";
import { EquipmentRequestDto } from "../model/dto/request/equipment-request.dto";

export interface EquipmentService {
  saveForEquipment(equipmentRequestDto: EquipmentRequestDto): Promise<DefaultResponse<string>>;

  getEquipmentList(usedBy: string, newOrUsed: string, page: number, perPageSize: number): Promise<DefaultResponse<EquipmentResponseDto[]>>;

  getEquipment(equipmentId: string): Promise<DefaultResponse<EquipmentResponseDto>>;

  deleteEquipment(equipmentId: string): DefaultResponse<string>;
}
