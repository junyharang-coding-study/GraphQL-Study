import { DefaultResponse } from "../../common/constant/default.response";
import { TeamRequestDto } from "../model/dto/request/team-request.dto";
import { TeamResponseDto } from "../model/dto/response/team-response.dto";
import { TeamUpdateRequestDto } from "../model/dto/request/team-update.request.dto";

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

  updateTeam(teamUpdateRequestDto: TeamUpdateRequestDto): Promise<DefaultResponse<number>>;

  deleteTeam(teamId: number): Promise<DefaultResponse<number>>;
}
