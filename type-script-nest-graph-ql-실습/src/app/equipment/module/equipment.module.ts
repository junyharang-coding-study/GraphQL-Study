import { Module } from "@nestjs/common";
import { EquipmentResolver } from "../resolver/equipment.resolver";
import { EquipmentImplService } from "../service/equipment-Impl.service";
import { TypeOrmModule } from "@nestjs/typeorm";
import { EquipmentQueryBuilderRepository } from "../repository/equipment-query-builder-repository.service";
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
    EquipmentQueryBuilderRepository,
    {
      provide: "EquipmentRepository",
      useClass: EquipmentQueryBuilderRepository,
    },
  ],
})
export class EquipmentModule {}
