import { Module } from "@nestjs/common";
import { TypeOrmModule } from "@nestjs/typeorm";
import { SoftwareServiceImpl } from "../service/software-service-impl.service";
import { SoftwareResolver } from "../resolver/software.resolver";
import { SoftwareQueryBuilderRepository } from "../repository/software-query-builder.repository";
import { SoftwareEntity } from "../model/entities/software.entity";

@Module({
  imports: [TypeOrmModule.forFeature([SoftwareEntity])],
  providers: [
    SoftwareResolver,
    SoftwareServiceImpl,
    {
      provide: "SoftwareService",
      useClass: SoftwareServiceImpl,
    },
    SoftwareQueryBuilderRepository,
    {
      provide: "SoftwareQueryBuilderRepository",
      useClass: SoftwareQueryBuilderRepository,
    },
  ],
})
export class SoftwareModule {}
