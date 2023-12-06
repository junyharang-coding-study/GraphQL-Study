import { HttpStatus, Inject, Injectable } from "@nestjs/common";
import { TeamService } from "./team-service.interface";
import { TeamRepository } from "../repository/team-interface.repository";
import { InjectRepository } from "@nestjs/typeorm";
import { Repository } from "typeorm";
import { TeamEntity } from "../model/entities/team.entity";
import { DefaultResponse } from "../../common/constant/default.response";
import { TeamResponseDto } from "../model/dto/response/team-response.dto";
import { TeamRequestDto } from "../model/dto/request/team-request.dto";
import { TeamUpdateRequestDto } from "../model/dto/request/team-update.request.dto";
import { Page } from "../../common/constant/page";
import { TeamSearchRequestDto } from "../model/dto/request/team-search-request.dto";
import { PeopleEntity } from "../../people/model/entities/people.entity";
import { SupplyEntity } from "../../supply/model/entities/supply.entity";

@Injectable()
export class TeamImplService implements TeamService {
  constructor(
    @InjectRepository(TeamEntity) private readonly teamRepository: Repository<TeamEntity>,
    @Inject("TeamQueryBuilderRepository") private readonly teamQueryBuilderRepository: TeamRepository,
  ) {}

  async saveTeam(teamRequestDto: TeamRequestDto): Promise<DefaultResponse<number>> {
    if (teamRequestDto === null) {
      return DefaultResponse.response(HttpStatus.NO_CONTENT, "Failed Create");
    }

    const savedPeople = await this.teamRepository.save(teamRequestDto.toEntity(teamRequestDto));

    if (savedPeople === null) {
      return DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error");
    }

    return DefaultResponse.responseWithData(HttpStatus.CREATED, "Success Create", savedPeople.teamId);
  }

  async getTeamList(
    manager: string,
    office: string,
    extensionNumber: string,
    mascot: string,
    cleaningDuty: string,
    project: string,
    pageNumber: number,
    perPageSize: number,
    orderBy: boolean,
  ): Promise<DefaultResponse<TeamResponseDto>> {
    const result = await this.teamQueryBuilderRepository.dynamicQuerySearchAndPagingByDto(
      TeamSearchRequestDto.toDto(manager, office, extensionNumber, mascot, cleaningDuty, project, pageNumber, perPageSize, orderBy),
    );

    if (result[0].length === 0) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.responseWithPaginationAndData(
      HttpStatus.OK,
      "Success",
      new Page(
        result[0].length,
        result[1],
        result[0].map((team: TeamEntity) => new TeamResponseDto(team)),
      ),
    );
  }

  async getTeam(teamId: number): Promise<DefaultResponse<TeamResponseDto>> {
    if (teamId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    const team = await this.teamRepository.findOne({ where: { teamId } });

    if (team === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.responseWithData(HttpStatus.OK, "OK", new TeamResponseDto(team));
  }

  async updateTeam(teamUpdateRequestDto: TeamUpdateRequestDto): Promise<DefaultResponse<number>> {
    const teamId = teamUpdateRequestDto.teamId;

    if (teamId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    if ((await this.teamRepository.findOne({ where: { teamId } })) === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Update Target Data Not Found");
    }

    await this.teamRepository.update(teamId, teamUpdateRequestDto.toEntity(teamUpdateRequestDto));

    return DefaultResponse.responseWithData(HttpStatus.OK, "Success Update", teamId);
  }

  async deleteTeam(teamId: number): Promise<DefaultResponse<number>> {
    if (teamId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    const deleteTargetByTeam = await this.teamRepository.findOne({ where: { teamId } });

    if (deleteTargetByTeam === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Delete Target Data Not Found");
    }

    const deleteResult = await this.teamRepository.delete(teamId);

    if (deleteResult === null) {
      return DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR, "Delete Failed");
    }

    return DefaultResponse.responseWithData(HttpStatus.OK, "OK", teamId);
  }
}
