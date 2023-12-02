import { IsString } from "class-validator";
import { PageRequestDto } from "../../../../common/constant/page.request.dto";

export class EquipmentSearchRequestDto extends PageRequestDto {
  @IsString()
  usedBy: string | null;

  @IsString()
  newOrUsed: string | null;

  constructor() {
    super();
  }

  static toDto(usedBy: string | null, newOrUsed: string | null, pageNumber: number | null, perPageSize: number | null): EquipmentSearchRequestDto {
    const equipmentSearchRequestDto = new EquipmentSearchRequestDto();
    equipmentSearchRequestDto.usedBy = usedBy;
    equipmentSearchRequestDto.newOrUsed = newOrUsed;
    equipmentSearchRequestDto.pageNumber = pageNumber;
    equipmentSearchRequestDto.perPageSize = perPageSize;
    return equipmentSearchRequestDto;
  }
}
