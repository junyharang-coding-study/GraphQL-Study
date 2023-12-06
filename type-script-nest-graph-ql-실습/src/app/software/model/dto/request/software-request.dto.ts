import { Field, InputType } from "@nestjs/graphql";
import { IsNotEmpty, IsString } from "class-validator";
import { SoftwareEntity } from "../../entities/software.entity";

@InputType()
export class SoftwareRequestDto {
  @IsString()
  @Field(() => String)
  softwareId: string;

  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  usedBy: string;

  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  developedBy: string;

  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  description: string;

  toEntity(softwareRequestDto: SoftwareRequestDto): SoftwareEntity {
    const software = new SoftwareEntity();
    software.softwareId = softwareRequestDto.softwareId;
    software.usedBy = softwareRequestDto.usedBy;
    software.developedBy = softwareRequestDto.developedBy;
    software.description = softwareRequestDto.description;
    return software;
  }
}
