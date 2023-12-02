import { Module } from "@nestjs/common";
import { GraphQLModule } from "@nestjs/graphql";
import { ApolloDriver, ApolloDriverConfig } from "@nestjs/apollo";
import { TypeOrmModule } from "@nestjs/typeorm";
import { ConfigModule } from "@nestjs/config";
import { CONFIG_VALIDATOR } from "./common/config/config.validator";
import { SqliteConfigProvider } from "./common/config/sqlite/sqlite-config.provider";
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
      installSubscriptionHandlers: true,
      // autoSchemaFile: join(process.cwd(), "src/graphql/schema.graphqls"),
      typePaths: ["./**/*.graphqls"],
    }),

    // TypeormCustomModule.forCustomRepository([EquipmentRepository]),
    EquipmentModule,
  ],
})
export class AppModule {}
