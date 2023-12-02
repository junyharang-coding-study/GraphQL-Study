import { Module } from "@nestjs/common";
import { EquipmentResolver } from "../resolver/equipment.resolver";
import { EquipmentServiceImpl } from "../service/equipment-service-impl";
import { TypeOrmModule } from "@nestjs/typeorm";
import { EquipmentRepository } from "../repository/equipment.repository";
import { EquipmentEntity } from "../model/entities/equipment.entity";

@Module({
  imports: [TypeOrmModule.forFeature([EquipmentEntity])],
  // exports: [TypeOrmModule],
  providers: [EquipmentResolver, EquipmentServiceImpl, EquipmentRepository],
})
export class EquipmentModule {}
