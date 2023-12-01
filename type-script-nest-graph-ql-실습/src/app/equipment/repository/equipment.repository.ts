import { Repository } from "typeorm";
import { Equipment } from "../model/entities/equipment";
import { TypeormRepository } from "../../common/custom/decorator/typeorm-repository.decorator";

@TypeormRepository(Equipment)
export class EquipmentRepository extends Repository<Equipment> {
  findByEquipmentId(equipmentId: string) {
    return this.findOne({ where: { equipmentId } });
  }
}
