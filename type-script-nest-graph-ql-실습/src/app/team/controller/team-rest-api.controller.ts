import { Controller, Get, Inject, Param } from "@nestjs/common";
import { TeamService } from "../service/team-service.interface";
import { ApiCreatedResponse, ApiOperation, ApiTags } from "@nestjs/swagger";
import { DefaultResponse } from "../../common/constant/default.response";
import { TeamAndMemberResponseDto } from "../model/dto/response/team-and-member-response.dto";

@ApiTags("TEAM 관련 API")
@Controller("team")
export class TeamRestApiController {
  constructor(@Inject("TeamService") private readonly teamService: TeamService) {}

  @ApiOperation({ summary: "Team과 People 정보 상세 조회", description: "Team과 People 정보 상세 조회 API Router" })
  @ApiCreatedResponse({ description: "Team과 People 정보 상세 조회 성공", type: DefaultResponse<TeamAndMemberResponseDto> })
  @Get("/team/:teamId")
  async getTeamByTeamId(@Param("teamId") teamId: number): Promise<DefaultResponse<TeamAndMemberResponseDto>> {
    return this.teamService.getTeamByTeamId(teamId);
  }
}
