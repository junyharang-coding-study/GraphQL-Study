import { Module } from "@nestjs/common";
import { TypeOrmModule } from "@nestjs/typeorm";
import { RoleEntity } from "../model/entities/role.entity";
import { RoleServiceImpl } from "../service/role-service-impl.service";
import { RoleQueryBuilderRepository } from "../resository/role-repository-impl.repository";
import { RoleResolver } from "../resolver/role.resolver";

@Module({
  imports: [TypeOrmModule.forFeature([RoleEntity])],
  providers: [
    RoleResolver,
    RoleServiceImpl,
    {
      provide: "RoleService",
      useClass: RoleServiceImpl,
    },
    RoleQueryBuilderRepository,
    {
      provide: "RoleQueryBuilderRepository",
      useClass: RoleQueryBuilderRepository,
    },
  ],
})
export class RoleModule {}
