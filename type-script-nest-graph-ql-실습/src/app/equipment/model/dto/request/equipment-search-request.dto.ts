import { PageRequestDto } from "../../../../common/constant/page.request.dto";
import { IsString } from "class-validator";
import { Field, InputType } from "@nestjs/graphql";

@InputType()
export class EquipmentSearchRequestDto extends PageRequestDto {
  @IsString() @Field(() => String) usedBy: string | null;
  @IsString() @Field(() => String) newOrUsed: string | null;

  constructor() {
    super();
  }

  static toDto(
    usedBy: string | null,
    newOrUsed: string | null,
    pageNumber: number | null,
    perPageSize: number | null,
    orderBy: boolean | true,
  ): EquipmentSearchRequestDto {
    const equipmentSearchRequestDto = new EquipmentSearchRequestDto();
    equipmentSearchRequestDto.usedBy = usedBy;
    equipmentSearchRequestDto.newOrUsed = newOrUsed;
    equipmentSearchRequestDto.pageNumber = pageNumber;
    equipmentSearchRequestDto.perPageSize = perPageSize;
    equipmentSearchRequestDto.orderBy = orderBy;
    return equipmentSearchRequestDto;
  }
}
