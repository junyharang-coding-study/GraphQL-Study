import { ConfigService } from "@nestjs/config";
import { DataSource } from "typeorm";
import { config } from "dotenv";

config();

const configService = new ConfigService();

export default new DataSource({
  type: "sqlite",
  database: configService.get("DB_HOST", ":memory:"),
  synchronize: true,
  entities: ["src/**/*.entity.ts"],
  migrations: ["src/database/migrations/*.ts"],
  migrationsTableName: "migrations",
});
