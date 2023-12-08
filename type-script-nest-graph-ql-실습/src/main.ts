import { NestFactory } from "@nestjs/core";
import { AppModule } from "./app.module";
import * as process from "process";
import { ValidationPipe } from "@nestjs/common";
import { swaggerConfig } from "./common/config/swagger.config";

declare const module: any;

async function bootstrap() {
  const app = await NestFactory.create(AppModule);
  swaggerConfig(app);
  const port = process.env.PORT || 8081;
  app.useGlobalPipes(new ValidationPipe({ transform: true })); // 글로벌 스코프 적용
  app.enableCors({
    // wrong!  in my case, anyway
    origin: "http://localhost:3000",
    methods: "GET,POST,",
    allowedHeaders: "Content-Type, Accept",
    credentials: true,
  });
  await app.listen(port);

  if (module.hot) {
    module.hot.accept();
    module.hot.dispose(() => app.close());
  }

  console.log(`주니의 Nest.js를 이용한 GraphQL 실습 서버 구동! Server Port Num: ${port}`);
}
bootstrap();
