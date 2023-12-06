import { Field, InputType } from "@nestjs/graphql";
import { IsNotEmpty, IsString } from "class-validator";
import { RoleEntity } from "../../entities/role.entity";

@InputType()
export class RoleRequestDto {
  @IsString()
  @Field(() => String)
  roleId: string;

  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  job: string;

  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  requirement: string;

  toEntity(roleRequestDto: RoleRequestDto): RoleEntity {
    const role = new RoleEntity();
    role.roleId = roleRequestDto.roleId;
    role.job = roleRequestDto.job;
    role.requirement = roleRequestDto.requirement;
    return role;
  }
}
