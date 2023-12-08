import { Module } from "@nestjs/common";
import { TypeOrmModule } from "@nestjs/typeorm";
import { RoleEntity } from "../model/entities/role.entity";
import { RoleServiceImpl } from "../service/role-service-impl.service";
import { RoleQueryBuilderRepository } from "../resository/role-repository-impl.repository";
import { RoleResolver } from "../resolver/role.resolver";
import { PeopleEntity } from "../../people/model/entities/people.entity";
import { EquipmentEntity } from "../../equipment/model/entities/equipment.entity";
import { SoftwareEntity } from "../../software/model/entities/software.entity";

@Module({
  imports: [TypeOrmModule.forFeature([RoleEntity, PeopleEntity, EquipmentEntity, SoftwareEntity])],
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
