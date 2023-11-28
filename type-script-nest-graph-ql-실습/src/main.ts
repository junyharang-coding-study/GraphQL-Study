import { NestFactory } from "@nestjs/core";
import { AppModule } from "./app.module";
import * as process from "process";
declare const module: any;

async function bootstrap() {
  const app = await NestFactory.create(AppModule);
  const port = process.env.PORT || 8081;
  await app.listen(port);

  if (module.hot) {
    module.hot.accept();
    module.hot.dispose(() => app.close());
  }

  console.log(`주니의 Nest.js를 이용한 GraphQL 실습 서버 구동! Server Port Num: ${port}`);
}
bootstrap();
