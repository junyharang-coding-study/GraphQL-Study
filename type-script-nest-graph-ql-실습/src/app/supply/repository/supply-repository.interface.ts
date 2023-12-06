import { SupplyEntity } from "../model/entities/supply.entity";
import { SupplySearchRequestDto } from "../model/dto/request/supply-search-request.dto";

export interface SupplyRepository {
  dynamicQuerySearchAndPagingByDto(supplySearchRequestDto: SupplySearchRequestDto): Promise<[SupplyEntity[], number]>;

  findOneJoinTeam(supplyId: string): Promise<SupplyEntity>;
}
