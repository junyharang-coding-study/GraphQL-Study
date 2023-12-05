import { PeopleRequestDto } from "../model/dto/request/people-request.dto";
import { DefaultResponse } from "../../common/constant/default.response";
import { PeopleSearchRequestDto } from "../model/dto/request/people-search-request.dto";
import { PeopleResponseDto } from "../model/dto/response/people.response.dto";
import { PeopleUpdateRequestDto } from "../model/dto/request/people-update-request.dto";

export interface PeopleService {
  savePeople(peopleRequestDto: PeopleRequestDto): Promise<DefaultResponse<number>>;

  getPeopleList(peopleSearchRequestDto: PeopleSearchRequestDto): Promise<DefaultResponse<PeopleResponseDto>>;

  getPeople(peopleId: number): Promise<DefaultResponse<PeopleResponseDto>>;

  updatePeople(peopleUpdateRequestDto: PeopleUpdateRequestDto): Promise<DefaultResponse<number>>;

  deletePeople(peopleId: number): Promise<DefaultResponse<number>>;
}
