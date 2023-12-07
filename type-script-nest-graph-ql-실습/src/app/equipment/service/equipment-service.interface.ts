import { EquipmentRequestDto } from "../model/dto/request/equipment-request.dto";
import { DefaultResponse } from "../../common/constant/default.response";
import { EquipmentResponseDto } from "../model/dto/response/equipment.response.dto";
import { EquipmentUpdateRequestDto } from "../model/dto/request/equipment-update-request.dto";
import { EquipmentAdvResponseDto } from "../model/dto/response/equipment-adv.response.dto";

export interface EquipmentService {
  saveForEquipment(equipmentRequestDto: EquipmentRequestDto): Promise<DefaultResponse<string>>;

  getEquipmentList(
    usedBy: string,
    newOrUsed: string,
    pageNumber: number,
    perPageSize: number,
    orderBy: boolean,
  ): Promise<DefaultResponse<EquipmentResponseDto>>;

  getEquipmentsAdv(
    usedBy: string,
    newOrUsed: string,
    pageNumber: number,
    perPageSize: number,
    orderBy: boolean,
  ): Promise<DefaultResponse<EquipmentAdvResponseDto>>;

  getEquipment(equipmentId: string): Promise<DefaultResponse<EquipmentResponseDto>>;

  updateEquipment(equipmentUpdateRequestDto: EquipmentUpdateRequestDto): Promise<DefaultResponse<string>>;

  deleteEquipment(equipmentId: string): Promise<DefaultResponse<string>>;
}
