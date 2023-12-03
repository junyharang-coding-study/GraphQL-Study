import { ConfigService } from "@nestjs/config";
import { DataSource } from "typeorm";
import { config } from "dotenv";
import { EquipmentEntity } from "./src/app/equipment/model/entities/equipment.entity";

config();

const configService = new ConfigService();

export default new DataSource({
  type: "sqlite",
  database: configService.get("DB_HOST", ":memory:"),
  synchronize: false,
  // entities: ["src/**/*.entity.ts"],
  // entities: [__dirname + "/../**/*.entity.ts"],
  entities: [EquipmentEntity],
  migrations: ["src/database/migrations/*.ts"],
  migrationsTableName: "migrations",
  logging: true, // 디버그 로깅 활성화
});
