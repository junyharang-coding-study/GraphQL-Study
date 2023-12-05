import { Injectable } from "@nestjs/common";
import { TypeOrmModuleOptions, TypeOrmOptionsFactory } from "@nestjs/typeorm";
import { ConfigService } from "@nestjs/config";
import { join } from "path";
import { EquipmentEntity } from "src/app/equipment/model/entities/equipment.entity";
import { PeopleEntity } from "../../../app/people/model/entities/people.entity";
import { TeamEntity } from "../../../app/team/model/entities/team.entity";
import { RoleEntity } from "../../../app/role/model/entities/role.entity";
import { SoftwareEntity } from "../../../app/software/model/entities/software.entity";
import { SupplyEntity } from "../../../app/supply/model/entities/supply.entity";

@Injectable()
export class SqliteConfigProvider implements TypeOrmOptionsFactory {
  constructor(private configService: ConfigService) {}

  createTypeOrmOptions(): TypeOrmModuleOptions {
    return {
      type: "sqlite",
      database: this.configService.get("DB_HOST", ":memory:"),
      synchronize: true,
      entities: [EquipmentEntity, PeopleEntity, RoleEntity, SoftwareEntity, SupplyEntity, TeamEntity],
      migrations: [join(__dirname, "**", "*.Seed*.{ts,js}")],
      migrationsTableName: "migrations",
      logging: true, // 디버그 로깅 활성화
    };
  }
}
