import { INestApplication } from "@nestjs/common";
import { DocumentBuilder, SwaggerModule } from "@nestjs/swagger";

export function swaggerConfig(app: INestApplication): void {
  const options = new DocumentBuilder()
    .setTitle("주니쓰")
    .setDescription("<h3> GraphQL을 공부해 봅시다! </h3>")
    .setVersion("1.0.0")
    // .addTag("Nest.ts GraphQL 실습")
    .build();

  const openAPIObject = SwaggerModule.createDocument(app, options);

  SwaggerModule.setup("swagger-ui/index.html", app, openAPIObject);
}
