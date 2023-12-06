import { TeamSearchRequestDto } from "../model/dto/request/team-search-request.dto";
import { TeamEntity } from "../model/entities/team.entity";

export interface TeamRepository {
  dynamicQuerySearchAndPagingByDto(teamSearchRequestDto: TeamSearchRequestDto): Promise<[TeamEntity[], number]>;
}
