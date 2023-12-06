import { IsNotEmpty, IsString } from "class-validator";
import { Field } from "@nestjs/graphql";
import { TeamEntity } from "../../entities/team.entity";

export class TeamRequestDto {
  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  manager: string;

  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  office: string;

  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  extensionNumber: string;

  @IsString()
  @Field(() => String)
  mascot: string;

  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  cleaningDuty: string;

  @IsString()
  @Field(() => String)
  project: string;

  toEntity(teamRequestDto: TeamRequestDto): TeamEntity {
    const team = new TeamEntity();
    team.manager = teamRequestDto.manager;
    team.office = teamRequestDto.office;
    team.extensionNumber = teamRequestDto.extensionNumber;
    team.mascot = teamRequestDto.mascot;
    team.cleaningDuty = teamRequestDto.cleaningDuty;
    team.project = teamRequestDto.project;
    return team;
  }
}
