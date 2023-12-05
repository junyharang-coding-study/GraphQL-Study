import { EquipmentEntity } from "../model/entities/equipment.entity";
import { EquipmentSearchRequestDto } from "../model/dto/request/equipment-search-request.dto";
import { DeleteResult, UpdateResult } from "typeorm";

export interface EquipmentRepository {
  saveEquipment(equipment: EquipmentEntity): Promise<EquipmentEntity>;

  dynamicQuerySearchAndPagingByDto(equipmentSearchRequestDto: EquipmentSearchRequestDto): Promise<[EquipmentEntity[], number]>;

  findByEquipmentId(equipmentId: string): Promise<EquipmentEntity>;

  updateEquipment(equipmentId: string, equipmentEntity: EquipmentEntity): Promise<UpdateResult>;

  delete(equipmentId: { equipmentId: string }): Promise<DeleteResult>;
}
