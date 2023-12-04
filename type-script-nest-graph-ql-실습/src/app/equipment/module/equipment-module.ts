import { Module } from "@nestjs/common";
import { EquipmentResolver } from "../resolver/equipment.resolver";
import { EquipmentService } from "../service/equipment.service";
import { TypeOrmModule } from "@nestjs/typeorm";
import { EquipmentRepository } from "../repository/equipment.repository";
import { EquipmentEntity } from "../model/entities/equipment.entity";

@Module({
  imports: [TypeOrmModule.forFeature([EquipmentEntity])],
  providers: [EquipmentResolver, EquipmentService, EquipmentRepository],
})
export class EquipmentModule {}
