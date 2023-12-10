import { Module } from "@nestjs/common";
import { TypeOrmModule } from "@nestjs/typeorm";
import { TeamEntity } from "../../team/model/entities/team.entity";
import { SupplyEntity } from "../model/entities/supply.entity";
import { SupplyQueryBuilderRepository } from "../repository/supply-query-builder.repository";
import { SupplyServiceImpl } from "../service/supply-service-impl.service";
import { SupplyResolver } from "../resolver/supply.resolver";

@Module({
  imports: [TypeOrmModule.forFeature([SupplyEntity, TeamEntity])],
  providers: [
    SupplyResolver,
    SupplyServiceImpl,
    {
      provide: "SupplyService",
      useClass: SupplyServiceImpl,
    },
    SupplyQueryBuilderRepository,
    {
      provide: "SupplyQueryBuilderRepository",
      useClass: SupplyQueryBuilderRepository,
    },
  ],
})
export class SupplyModuleModule {}
