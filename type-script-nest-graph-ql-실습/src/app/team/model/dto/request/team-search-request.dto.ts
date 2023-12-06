import { Field, InputType } from "@nestjs/graphql";
import { IsString } from "class-validator";
import { PageRequestDto } from "../../../../common/constant/page.request.dto";

@InputType()
export class TeamSearchRequestDto extends PageRequestDto {
  @IsString()
  @Field(() => String)
  manager: string;

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

  static toDto(
    manager: string | null,
    office: string | null,
    extensionNumber: string | null,
    mascot: string | null,
    cleaningDuty: string | null,
    project: string | null,
    pageNumber: number | null,
    perPageSize: number | null,
    orderBy: boolean | true,
  ): TeamSearchRequestDto {
    const teamSearchRequestDto = new TeamSearchRequestDto();
    teamSearchRequestDto.manager = manager;
    teamSearchRequestDto.office = office;
    teamSearchRequestDto.extensionNumber = extensionNumber;
    teamSearchRequestDto.mascot = mascot;
    teamSearchRequestDto.cleaningDuty = cleaningDuty;
    teamSearchRequestDto.project = project;
    teamSearchRequestDto.pageNumber = pageNumber;
    teamSearchRequestDto.perPageSize = perPageSize;
    teamSearchRequestDto.orderBy = orderBy;
    return teamSearchRequestDto;
  }
}
