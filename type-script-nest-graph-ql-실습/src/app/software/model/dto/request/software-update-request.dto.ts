import { Field, InputType } from "@nestjs/graphql";
import { IsNotEmpty, IsString } from "class-validator";
import { SoftwareEntity } from "../../entities/software.entity";

@InputType()
export class SoftwareUpdateRequestDto {
  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  softwareId: string;

  @IsString()
  @Field(() => String)
  usedBy: string;

  @IsString()
  @Field(() => String)
  developedBy: string;

  @IsString()
  @Field(() => String)
  description: string;

  toEntity(softwareUpdateRequestDto: SoftwareUpdateRequestDto): SoftwareEntity {
    const software = new SoftwareEntity();
    software.usedBy = softwareUpdateRequestDto.usedBy;
    software.developedBy = softwareUpdateRequestDto.developedBy;
    software.description = softwareUpdateRequestDto.description;
    return software;
  }
}
