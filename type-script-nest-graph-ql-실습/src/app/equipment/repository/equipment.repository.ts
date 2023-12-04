import { Repository, UpdateResult } from "typeorm";
import { EquipmentEntity } from "../model/entities/equipment.entity";
import { EquipmentSearchRequestDto } from "../model/dto/request/equipment-search-request.dto";
import { Injectable } from "@nestjs/common";
import { InjectRepository } from "@nestjs/typeorm";

@Injectable()
export class EquipmentRepository {
  constructor(@InjectRepository(EquipmentEntity) private readonly equipmentRepository: Repository<EquipmentEntity>) {}

  async saveEquipment(equipment: EquipmentEntity): Promise<EquipmentEntity> {
    return this.equipmentRepository.save(equipment);
  }

  async dynamicQuerySearchAndPagingByDto(equipmentSearchRequestDto: EquipmentSearchRequestDto): Promise<EquipmentEntity[]> {
    const selectQueryBuilder = this.equipmentRepository
      .createQueryBuilder("equipment")
      .limit(equipmentSearchRequestDto.getPerPageSize())
      .offset(equipmentSearchRequestDto.getPageNumber());

    if (equipmentSearchRequestDto.usedBy) {
      selectQueryBuilder.andWhere("equipment.usedBy = :usedBy", { usedBy: `${equipmentSearchRequestDto.usedBy}` });
    }

    if (equipmentSearchRequestDto.newOrUsed) {
      selectQueryBuilder.andWhere("equipment.newOrUsed = :newOrUsed", { newOrUsed: `${equipmentSearchRequestDto.newOrUsed}` });
    }

    if (equipmentSearchRequestDto.orderBy === true) {
      selectQueryBuilder.orderBy("equipment.equipmentId", "DESC");
    }

    return await selectQueryBuilder.getMany();
  }

  findByEquipmentId(equipmentId: string): Promise<EquipmentEntity> {
    return this.equipmentRepository.findOne({ where: { equipmentId } });
  }

  updateEquipment(equipmentId: string, equipmentEntity: EquipmentEntity): Promise<UpdateResult> {
    return this.equipmentRepository.update(equipmentId, equipmentEntity);
  }

  delete(equipmentId: { equipmentId: string }) {
    return this.equipmentRepository.delete(equipmentId);
  }
}
