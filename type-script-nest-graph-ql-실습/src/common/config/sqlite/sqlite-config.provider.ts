import { Injectable } from "@nestjs/common";
import { TypeOrmModuleOptions, TypeOrmOptionsFactory } from "@nestjs/typeorm";
import { ConfigService } from "@nestjs/config";

@Injectable()
export class SqliteConfigProvider implements TypeOrmOptionsFactory {
  constructor(private configService: ConfigService) {}

  createTypeOrmOptions(): TypeOrmModuleOptions {
    return {
      type: "sqlite",
      database: this.configService.get("DB_HOST", ":memory:"),
      synchronize: true,
      entities: ["src/**/*.entity.ts"],
      migrations: ["src/database/migrations/**/*.ts"],
      migrationsTableName: "migrations",
    };
  }
}
