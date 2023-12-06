import { InputType } from "@nestjs/graphql";
import { PageRequestDto } from "../../../../common/constant/page.request.dto";

@InputType()
export class SupplySearchRequestDto extends PageRequestDto {
  teamId: number | null;

  constructor() {
    super();
  }

  static toDto(teamId: number | null, pageNumber: number | null, perPageSize: number | null, orderBy: boolean | true): SupplySearchRequestDto {
    const supplySearchRequestDto = new SupplySearchRequestDto();
    supplySearchRequestDto.teamId = teamId;
    supplySearchRequestDto.pageNumber = pageNumber;
    supplySearchRequestDto.perPageSize = perPageSize;
    supplySearchRequestDto.orderBy = orderBy;
    return supplySearchRequestDto;
  }
}
