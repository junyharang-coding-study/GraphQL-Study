import { PageRequestDto } from "../../../../common/constant/page.request.dto";

export class EquipmentSearchRequestDto extends PageRequestDto {
  usedBy: string | null;
  newOrUsed: string | null;

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
