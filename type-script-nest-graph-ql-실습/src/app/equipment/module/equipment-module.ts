import { Module } from "@nestjs/common";
import { EquipmentResolver } from "../resolver/equipment.resolver";
import { EquipmentImplService } from "../service/equipment-Impl.service";
import { TypeOrmModule } from "@nestjs/typeorm";
import { EquipmentImplRepository } from "../repository/equipment-Impl.repository";
import { EquipmentEntity } from "../model/entities/equipment.entity";

@Module({
  imports: [TypeOrmModule.forFeature([EquipmentEntity])],
  providers: [
    EquipmentResolver,
    EquipmentImplService,
    {
      provide: "EquipmentService",
      useClass: EquipmentImplService,
    },
    EquipmentImplRepository,
    {
      provide: "EquipmentRepository",
      useClass: EquipmentImplRepository,
    },
  ],
})
export class EquipmentModule {}
