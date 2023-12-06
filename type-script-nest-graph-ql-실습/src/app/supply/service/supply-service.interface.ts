import { SupplyRequestDto } from "../model/dto/request/supply-request.dto";
import { DefaultResponse } from "../../common/constant/default.response";
import { SupplyResponseDto } from "../model/dto/response/supply-response.dto";
import { SupplyUpdateRequestDto } from "../model/dto/request/supply-update-request.dto";

export interface SupplyService {
  saveSupply(supplyRequestDto: SupplyRequestDto): Promise<DefaultResponse<string>>;

  getSupplyList(teamId: number, pageNumber: number, perPageSize: number, orderBy: boolean): Promise<DefaultResponse<SupplyResponseDto>>;

  getSupply(supplyId: string): Promise<DefaultResponse<SupplyResponseDto>>;

  updateSupply(supplyUpdateRequestDto: SupplyUpdateRequestDto): Promise<DefaultResponse<string>>;

  deleteSupply(supplyId: string): Promise<DefaultResponse<string>>;
}
