import { TypeormRepository } from "../../common/custom/decorator/typeorm-repository.decorator";
import { Equipment } from "../model/entities/equipment";
import { EquipmentSearchRequestDto } from "../model/dto/request/equipment-search-request.dto";
import dataSource from "../../../../data-source";

@TypeormRepository(Equipment)
export class EquipmentQueryBuilderRepository {
  dynamicQueryByDto(equipmentSearchRequestDto: EquipmentSearchRequestDto): Promise<[Equipment[], number]> {
    const selectQueryBuilder = dataSource
      .getRepository(Equipment)
      .createQueryBuilder("equipment")
      .select(["equipment.id", "equipment.usedBy", "equipment.count", "newOrUsed.count"])
      .from(Equipment, "equipment")
      .limit(equipmentSearchRequestDto.getLimit())
      .offset(equipmentSearchRequestDto.getOffset());

    if (this.hasSearchUsedBy(equipmentSearchRequestDto.usedBy)) {
      selectQueryBuilder.andWhere("equipment.usedBy = :usedBy", { usedBy: `%${equipmentSearchRequestDto.usedBy}` });
    }

    if (this.hasNewOrUsed(equipmentSearchRequestDto.newOrUsed)) {
      selectQueryBuilder.andWhere("equipment.newOrUsed = :newOrUsed", { usedBy: `%${equipmentSearchRequestDto.newOrUsed}` });
    }

    return selectQueryBuilder.disableEscaping().getManyAndCount();
  }

  private hasSearchUsedBy(usedBy: string): boolean {
    return usedBy !== null;
  }

  private hasNewOrUsed(newOrUsed: string) {
    return newOrUsed !== null;
  }
}
