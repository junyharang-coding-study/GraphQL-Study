import { PeopleEntity } from "../model/entities/people.entity";
import { PeopleSearchRequestDto } from "../model/dto/request/people-search-request.dto";

export interface PeopleRepository {
  dynamicQuerySearchAndPagingByDto(peopleSearchRequestDto: PeopleSearchRequestDto): Promise<[PeopleEntity[], number]>;

  findOneJoinTeam(peopleId: number): Promise<PeopleEntity>;
}
