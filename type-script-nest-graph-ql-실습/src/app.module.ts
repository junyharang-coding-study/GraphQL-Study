import { Module } from "@nestjs/common";
import { AppController } from "./app.controller";
import { AppService } from "./app.service";
import { GraphQLModule } from "@nestjs/graphql";
import { ApolloDriver, ApolloDriverConfig } from "@nestjs/apollo";
import { TypeOrmModule } from "@nestjs/typeorm";
import { ConfigModule } from "@nestjs/config";
import { CONFIG_VALIDATOR } from "./common/config/config.validator";
import { SqliteConfigProvider } from "./common/config/sqlite/sqlite-config.provider";
import { EquipmentResolver } from "./app/equipment/resolver/equipment.resolver";
import { EquipmentServiceImpl } from "./app/equipment/service/equipment-service-impl";
import { EquipmentModule } from "./app/equipment/module/equipment-module";
import { TypeormCustomModule } from "./app/common/custom/module/typeorm-custom.module";
import { EquipmentRepository } from "./app/equipment/repository/equipment.repository";

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
    }),

    TypeormCustomModule.forCustomRepository([EquipmentRepository]),

    EquipmentModule,
  ],
  controllers: [AppController, EquipmentResolver],
  providers: [AppService, EquipmentServiceImpl],
})
export class AppModule {}
