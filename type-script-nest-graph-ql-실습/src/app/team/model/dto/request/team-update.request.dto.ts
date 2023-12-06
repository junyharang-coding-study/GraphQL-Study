import { Field, InputType } from "@nestjs/graphql";
import { IsInt, IsNotEmpty, IsString } from "class-validator";
import { TeamEntity } from "../../entities/team.entity";

@InputType()
export class TeamUpdateRequestDto {
  @IsNotEmpty()
  @IsInt()
  @Field(() => Number)
  teamId: number;

  @IsString()
  @Field(() => String)
  office: string;

  @IsString()
  @Field(() => String)
  extensionNumber: string;

  @IsString()
  @Field(() => String)
  mascot: string;

  @IsString()
  @Field(() => String)
  cleaningDuty: string;

  @IsString()
  @Field(() => String)
  project: string;

  toEntity(teamUpdateRequestDto: TeamUpdateRequestDto): TeamEntity {
    const team = new TeamEntity();
    team.office = teamUpdateRequestDto.office;
    team.extensionNumber = teamUpdateRequestDto.extensionNumber;
    team.mascot = teamUpdateRequestDto.mascot;
    team.cleaningDuty = teamUpdateRequestDto.cleaningDuty;
    team.project = teamUpdateRequestDto.project;
    return team;
  }
}
