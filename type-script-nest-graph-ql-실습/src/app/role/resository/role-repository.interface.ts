import { RoleEntity } from "../model/entities/role.entity";
import { RoleSearchRequestDto } from "../model/dto/request/role-search-request.dto";

export interface RoleRepository {
  dynamicQuerySearchAndPagingByDto(roleSearchRequestDto: RoleSearchRequestDto): Promise<[RoleEntity[], number]>;
}
