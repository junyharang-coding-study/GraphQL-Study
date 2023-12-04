import { ConfigService } from "@nestjs/config";
import { DataSource } from "typeorm";
import { config } from "dotenv";
import { join } from "path";

config();

const configService = new ConfigService();

export default new DataSource({
  type: "sqlite",
  database: configService.get("DB_HOST", ":memory:"),
  synchronize: false,
  entities: [join(__dirname, "**", "*.entity.{ts,js}")],
  migrations: ["src/database/migrations/*.ts"],
  migrationsTableName: "migrations",
  logging: true, // 디버그 로깅 활성화
});
