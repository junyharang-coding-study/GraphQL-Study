import { PageRequestDto } from "../../../../common/constant/page.request.dto";
import { IsString } from "class-validator";
import { Field, InputType } from "@nestjs/graphql";

@InputType()
export class RoleSearchRequestDto extends PageRequestDto {
  @IsString() @Field(() => String) job: string | null;
  @IsString() @Field(() => String) requirement: string | null;

  constructor() {
    super();
  }
}
