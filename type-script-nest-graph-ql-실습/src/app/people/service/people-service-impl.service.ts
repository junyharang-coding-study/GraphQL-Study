import { HttpStatus, Inject, Injectable, Logger } from "@nestjs/common";
import { PeopleService } from "./people-service.interface";
import { PeopleRepository } from "../repository/people-repository.interface";
import { DefaultResponse } from "../../common/constant/default.response";
import { PeopleSearchRequestDto } from "../model/dto/request/people-search-request.dto";
import { PeopleResponseDto } from "../model/dto/response/people.response.dto";
import { PeopleRequestDto } from "../model/dto/request/people-request.dto";
import { PeopleUpdateRequestDto } from "../model/dto/request/people-update-request.dto";
import { PeopleEntity } from "../model/entities/people.entity";
import { Page } from "../../common/constant/page";
import { InjectRepository } from "@nestjs/typeorm";
import { Repository } from "typeorm";
import { TeamEntity } from "../../team/model/entities/team.entity";

@Injectable()
export class PeopleServiceImpl implements PeopleService {
  constructor(
    @InjectRepository(PeopleEntity) private readonly peopleRepository: Repository<PeopleEntity>,
    @Inject("PeopleQueryBuilderRepository") private readonly peopleQueryBuilderRepository: PeopleRepository,
    @InjectRepository(TeamEntity) private readonly teamRepository: Repository<TeamEntity>,
  ) {}

  async savePeople(peopleRequestDto: PeopleRequestDto): Promise<DefaultResponse<number>> {
    if (peopleRequestDto === null) {
      return DefaultResponse.response(HttpStatus.NO_CONTENT, "Failed Create");
    }

    const teamId = peopleRequestDto.teamId;

    if ((await this.teamRepository.findOne({ where: { teamId } })) === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Non-existent team information");
    }

    const savedPeople = await this.peopleRepository.save(peopleRequestDto.toEntity(peopleRequestDto));

    if (savedPeople === null) {
      return DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error");
    }

    return DefaultResponse.responseWithData(HttpStatus.CREATED, "Success Create", savedPeople.peopleId);
  }

  async getPeopleList(peopleSearchRequestDto: PeopleSearchRequestDto): Promise<DefaultResponse<PeopleResponseDto>> {
    const result = await this.peopleQueryBuilderRepository.dynamicQuerySearchAndPagingByDto(peopleSearchRequestDto);

    if (result[0].length === 0) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.responseWithPaginationAndData(
      HttpStatus.OK,
      "Success",
      new Page(
        result[0].length,
        result[1],
        result[0].map((people) => new PeopleResponseDto(people)),
      ),
    );
  }

  async getPeople(peopleId: number): Promise<DefaultResponse<PeopleResponseDto>> {
    if (peopleId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    const people = await this.peopleQueryBuilderRepository.findOneJoinTeam(peopleId);

    if (people === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.responseWithData(HttpStatus.OK, "OK", new PeopleResponseDto(people));
  }

  async updatePeople(peopleUpdateRequestDto: PeopleUpdateRequestDto): Promise<DefaultResponse<number>> {
    const peopleId = peopleUpdateRequestDto.peopleId;

    if (peopleId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    if ((await this.peopleQueryBuilderRepository.findOneJoinTeam(peopleId)) === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    await this.peopleRepository.update(peopleId, peopleUpdateRequestDto.toEntity(peopleUpdateRequestDto));

    return DefaultResponse.responseWithData(HttpStatus.OK, "Success Update", peopleId);
  }

  async deletePeople(peopleId: number): Promise<DefaultResponse<number>> {
    if (peopleId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    if ((await this.peopleQueryBuilderRepository.findOneJoinTeam(peopleId)) === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    const deleteResult = await this.peopleRepository.delete({ peopleId: peopleId });

    if (deleteResult === null) {
      return DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR, "Delete Failed");
    }

    return DefaultResponse.responseWithData(HttpStatus.OK, "OK", peopleId);
  }
}
