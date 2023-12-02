import { Repository } from "typeorm";
import { EquipmentEntity } from "../model/entities/equipment.entity";
import { EquipmentSearchRequestDto } from "../model/dto/request/equipment-search-request.dto";
import dataSource from "../../../../data-source";
import { Injectable, Logger } from "@nestjs/common";
import { EquipmentRequestDto } from "../model/dto/request/equipment-request.dto";
import { TypeormRepository } from "../../common/custom/decorator/typeorm-repository.decorator";

@Injectable()
@TypeormRepository(EquipmentEntity)
export class EquipmentRepository extends Repository<EquipmentEntity> {
  private logger = new Logger("equipment.repository.ts");

  async saveEquipment(equipmentRequestDto: EquipmentRequestDto): Promise<EquipmentEntity> {
    const { equipmentId, usedBy, count, newOrUsed } = equipmentRequestDto;

    const saveEquipment = this.create({ equipmentId, usedBy, count, newOrUsed });
    await this.save(saveEquipment);

    return saveEquipment;
  }

  dynamicQueryByDto(equipmentSearchRequestDto: EquipmentSearchRequestDto): Promise<[EquipmentEntity[], number]> {
    this.logger.log("EquipmentRepository - dynamicQueryByDto 동작");
    this.logger.log(`EquipmentSearchRequestDto 타입: ${typeof equipmentSearchRequestDto}`);
    console.log(equipmentSearchRequestDto);

    const selectQueryBuilder = dataSource
      .getRepository(EquipmentEntity)
      .createQueryBuilder("equipment")
      .select(["equipment.id", "equipment.usedBy", "equipment.count", "equipment.newOrUsed"])
      .from(EquipmentEntity, "equipment")
      .limit(equipmentSearchRequestDto.getLimit())
      .offset(equipmentSearchRequestDto.getOffset());

    if (this.hasSearchUsedBy(equipmentSearchRequestDto.usedBy)) {
      selectQueryBuilder.andWhere("equipment.usedBy = :usedBy", { usedBy: `%${equipmentSearchRequestDto.usedBy}%` });
    }

    if (this.hasNewOrUsed(equipmentSearchRequestDto.newOrUsed)) {
      selectQueryBuilder.andWhere("equipment.newOrUsed = :newOrUsed", { usedBy: `%${equipmentSearchRequestDto.newOrUsed}%` });
    }

    this.logger.log(`selectQueryBuilder 값: ${selectQueryBuilder.getQuery()}`);

    return selectQueryBuilder.disableEscaping().getManyAndCount();
  }

  private hasSearchUsedBy(usedBy: string): boolean {
    return usedBy !== null;
  }

  private hasNewOrUsed(newOrUsed: string) {
    return newOrUsed !== null;
  }

  findByEquipmentId(equipmentId: string) {
    return this.findOne({ where: { equipmentId } });
  }
}
