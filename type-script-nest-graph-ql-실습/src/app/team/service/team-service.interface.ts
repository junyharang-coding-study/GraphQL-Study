import { DefaultResponse } from "../../common/constant/default.response";
import { TeamRequestDto } from "../model/dto/request/team-request.dto";
import { TeamResponseDto } from "../model/dto/response/team-response.dto";
import { TeamUpdateRequestDto } from "../model/dto/request/team-update.request.dto";
import { TeamAndMemberResponseDto } from "../model/dto/response/team-and-member-response.dto";

export interface TeamService {
  saveTeam(teamRequestDto: TeamRequestDto): Promise<DefaultResponse<number>>;

  getTeamList(
    manager: string,
    office: string,
    extensionNumber: string,
    mascot: string,
    cleaningDuty: string,
    project: string,
    pageNumber: number,
    perPageSize: number,
    orderBy: boolean,
  ): Promise<DefaultResponse<TeamResponseDto>>;

  getTeam(teamId: number): Promise<DefaultResponse<TeamResponseDto>>;

  getTeamByTeamId(teamId: number): Promise<DefaultResponse<TeamAndMemberResponseDto>>;

  updateTeam(teamUpdateRequestDto: TeamUpdateRequestDto): Promise<DefaultResponse<number>>;

  deleteTeam(teamId: number): Promise<DefaultResponse<number>>;
}
