import { Module } from "@nestjs/common";
import { GraphQLModule } from "@nestjs/graphql";
import { ApolloDriver, ApolloDriverConfig } from "@nestjs/apollo";
import { TypeOrmModule } from "@nestjs/typeorm";
import { ConfigModule } from "@nestjs/config";
import { CONFIG_VALIDATOR } from "./common/config/config.validator";
import { SqliteConfigProvider } from "./common/config/sqlite/sqlite-config.provider";
import { EquipmentModule } from "./app/equipment/module/equipment.module";
import { PeopleModule } from "./app/people/module/people.module";
import { RoleModule } from "./app/role/module/role.module";
import { SoftwareModule } from "./app/software/module/software.module";
import { TeamModule } from "./app/team/module/team.module";

@Module({
  imports: [
    // ConfigModule 설정 추가
    ConfigModule.forRoot(CONFIG_VALIDATOR),
    TypeOrmModule.forRootAsync({
      useClass: SqliteConfigProvider,
    }),

    GraphQLModule.forRoot<ApolloDriverConfig>({
      driver: ApolloDriver,
      playground: true,
      installSubscriptionHandlers: true,
      typePaths: ["./**/*.graphqls"],
    }),
    EquipmentModule,
    PeopleModule,
    RoleModule,
    SoftwareModule,
    TeamModule,
  ],
})
export class AppModule {}
