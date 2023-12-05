import { EquipmentRequestDto } from "../model/dto/request/equipment-request.dto";
import { DefaultResponse } from "../../common/constant/default.response";
import { EquipmentResponseDto } from "../model/dto/response/equipment.response.dto";
import { EquipmentUpdateRequestDto } from "../model/dto/request/equipment-update-request.dto";

export interface EquipmentService {
  saveForEquipment(equipmentRequestDto: EquipmentRequestDto): Promise<DefaultResponse<string>>;

  getEquipmentList(
    usedBy: string,
    newOrUsed: string,
    page: number,
    perPageSize: number,
    orderBy: boolean,
  ): Promise<DefaultResponse<EquipmentResponseDto>>;

  getEquipment(equipmentId: string): Promise<DefaultResponse<EquipmentResponseDto>>;

  updateEquipment(equipmentUpdateRequestDto: EquipmentUpdateRequestDto): Promise<DefaultResponse<string>>;

  deleteEquipment(equipmentId: string): Promise<DefaultResponse<string>>;
}
