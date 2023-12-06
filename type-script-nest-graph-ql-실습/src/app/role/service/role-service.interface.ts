import { RoleRequestDto } from "../model/dto/request/role-request.dto";
import { DefaultResponse } from "../../common/constant/default.response";
import { RoleSearchRequestDto } from "../model/dto/request/role-search-request.dto";
import { RoleResponseDto } from "../model/dto/response/role-response.dto";
import { RoleUpdateRequestDto } from "../model/dto/request/role-update-request.dto";

export interface RoleService {
  saveRole(roleRequestDto: RoleRequestDto): Promise<DefaultResponse<string>>;

  getRoleList(roleSearchRequestDto: RoleSearchRequestDto): Promise<DefaultResponse<RoleResponseDto>>;

  getRole(roleId: string): Promise<DefaultResponse<RoleResponseDto>>;

  updateRole(roleUpdateRequestDto: RoleUpdateRequestDto): Promise<DefaultResponse<string>>;

  deleteRole(roleId: string): Promise<DefaultResponse<string>>;
}
