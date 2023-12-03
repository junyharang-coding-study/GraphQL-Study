import { Repository, UpdateResult } from "typeorm";
import { EquipmentEntity } from "../model/entities/equipment.entity";
import { EquipmentSearchRequestDto } from "../model/dto/request/equipment-search-request.dto";
import dataSource from "../../../../data-source";
import { Injectable, Logger } from "@nestjs/common";
import { EquipmentRequestDto } from "../model/dto/request/equipment-request.dto";
import { InjectRepository } from "@nestjs/typeorm";

@Injectable()
// @TypeormRepository(EquipmentEntity)
export class EquipmentRepository {
  private logger = new Logger("equipment.repository.ts");

  constructor(@InjectRepository(EquipmentEntity) private readonly equipmentRepository: Repository<EquipmentEntity>) {}

  async saveEquipment(equipment: EquipmentEntity): Promise<EquipmentEntity> {
    return this.equipmentRepository.save(equipment);
  }

  dynamicQuerySearchAndPagingByDto(equipmentSearchRequestDto: EquipmentSearchRequestDto): Promise<[EquipmentEntity[], number]> {
    this.logger.log("EquipmentRepository - dynamicQueryByDto 동작");
    this.logger.log(`EquipmentSearchRequestDto 타입: ${typeof equipmentSearchRequestDto}`);
    console.log(equipmentSearchRequestDto);

    const selectQueryBuilder = this.equipmentRepository
      .createQueryBuilder("equipment")
      .limit(equipmentSearchRequestDto.getPerPageSize())
      .offset(equipmentSearchRequestDto.getPageNumber());

    if (this.hasSearchUsedBy(equipmentSearchRequestDto.usedBy)) {
      selectQueryBuilder.andWhere("equipment.usedBy = :usedBy", { usedBy: `%${equipmentSearchRequestDto.usedBy}%` });
    }

    if (this.hasNewOrUsed(equipmentSearchRequestDto.newOrUsed)) {
      selectQueryBuilder.andWhere("equipment.newOrUsed = :newOrUsed", { usedBy: `%${equipmentSearchRequestDto.newOrUsed}%` });
    }

    return selectQueryBuilder.disableEscaping().getManyAndCount();
  }

  private hasSearchUsedBy(usedBy: string): boolean {
    return usedBy !== undefined;
  }

  private hasNewOrUsed(newOrUsed: string) {
    return newOrUsed !== undefined;
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
