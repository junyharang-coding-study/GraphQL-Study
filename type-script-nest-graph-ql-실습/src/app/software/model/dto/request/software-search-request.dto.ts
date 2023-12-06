import { Field, InputType } from "@nestjs/graphql";
import { PageRequestDto } from "../../../../common/constant/page.request.dto";
import { IsString } from "class-validator";

@InputType()
export class SoftwareSearchRequestDto extends PageRequestDto {
  @IsString()
  @Field(() => String)
  usedBy: string;

  @IsString()
  @Field(() => String)
  developedBy: string;

  @IsString()
  @Field(() => String)
  description: string;

  static toDto(
    usedBy: string | null,
    developedBy: string | null,
    description: string | null,
    pageNumber: number | null,
    perPageSize: number | null,
    orderBy: boolean | true,
  ): SoftwareSearchRequestDto {
    const softwareSearchRequestDto = new SoftwareSearchRequestDto();
    softwareSearchRequestDto.usedBy = usedBy;
    softwareSearchRequestDto.developedBy = developedBy;
    softwareSearchRequestDto.description = description;
    softwareSearchRequestDto.pageNumber = pageNumber;
    softwareSearchRequestDto.perPageSize = perPageSize;
    softwareSearchRequestDto.orderBy = orderBy;
    return softwareSearchRequestDto;
  }
}
