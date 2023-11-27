import { Module } from "@nestjs/common";
import { AppController } from "./app.controller";
import { AppService } from "./app.service";
import { GraphQLModule } from "@nestjs/graphql";
import { ApolloServerPluginLandingPageGraphQLPlayground } from "apollo-server-core";
import { TypeOrmModule } from "@nestjs/typeorm";
@Module({
  imports: [
    TypeOrmModule.forRoot({
      type: "sqlite",
      database: ":memory",
      entities: [__dirname + "/**/*.entity{.ts,.js}"],
      // 서버 구동 시 DB 초기화 설정
      synchronize: true,
    }),

    GraphQLModule.forRoot({
      // Memory 저장
      autoSchemaFile: true,
      driver: {
        provide: "APOLLO_DRIVER",
        useValue: ApolloServerPluginLandingPageGraphQLPlayground,
      },
    }),
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
