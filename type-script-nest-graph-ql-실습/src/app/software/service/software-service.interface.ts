import { SoftwareRequestDto } from "../model/dto/request/software-request.dto";
import { DefaultResponse } from "../../common/constant/default.response";
import { SoftwareResponseDto } from "../model/dto/response/software-response.dto";
import { SoftwareUpdateRequestDto } from "../model/dto/request/software-update-request.dto";

export interface SoftwareService {
  saveSoftware(softwareRequestDto: SoftwareRequestDto): Promise<DefaultResponse<string>>;

  getSoftwareList(
    usedBy: string,
    developedBy: string,
    description: string,
    pageNumber: number,
    perPageSize: number,
    orderBy: boolean,
  ): Promise<DefaultResponse<SoftwareResponseDto>>;

  getSoftware(softwareId: string): Promise<DefaultResponse<SoftwareResponseDto>>;

  updateSoftware(softwareUpdateRequestDto: SoftwareUpdateRequestDto): Promise<DefaultResponse<string>>;

  deleteSoftware(softwareId: string): Promise<DefaultResponse<string>>;
}
