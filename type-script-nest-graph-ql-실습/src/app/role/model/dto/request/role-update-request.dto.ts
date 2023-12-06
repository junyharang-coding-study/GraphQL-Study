import { IsNotEmpty, IsString } from "class-validator";
import { Field, InputType } from "@nestjs/graphql";
import { RoleEntity } from "../../entities/role.entity";

@InputType()
export class RoleUpdateRequestDto {
  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  roleId: string;

  @IsString()
  @Field(() => String)
  job: string;

  @IsString()
  @Field(() => String)
  requirement: string;

  toEntity(roleUpdateRequestDto: RoleUpdateRequestDto): RoleEntity {
    const role = new RoleEntity();
    role.job = roleUpdateRequestDto.job;
    role.requirement = roleUpdateRequestDto.requirement;
    return role;
  }
}
