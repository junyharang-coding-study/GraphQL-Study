import { SetMetadata } from "@nestjs/common";

export function TypeormRepository(entity: Function): ClassDecorator {
  return SetMetadata("TYPEORM_CUSTOM_REPOSITORY", entity);
}
