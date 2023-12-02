import { Injectable } from "@nestjs/common";
import { TypeOrmModuleOptions, TypeOrmOptionsFactory } from "@nestjs/typeorm";
import { ConfigService } from "@nestjs/config";
import { join } from "path";

@Injectable()
export class SqliteConfigProvider implements TypeOrmOptionsFactory {
  constructor(private configService: ConfigService) {}

  createTypeOrmOptions(): TypeOrmModuleOptions {
    return {
      type: "sqlite",
      database: this.configService.get("DB_HOST", ":memory:"),
      synchronize: true,
      entities: [join(__dirname, "**", "*.entity.{ts,js}")],
      // migrations: ["src/database/migrations/**/*.ts"],
      migrations: [join(__dirname, "**", "*.Seed*.{ts,js}")],
      migrationsTableName: "migrations",
    };
  }
}
