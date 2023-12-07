import { Args, Int, Mutation, Query, Resolver } from "@nestjs/graphql";
import { TeamEntity } from "../model/entities/team.entity";
import { Body, Inject, UsePipes, ValidationPipe } from "@nestjs/common";
import { TeamService } from "../service/team-service.interface";
import { DefaultResponse } from "../../common/constant/default.response";
import { TeamResponseDto } from "../model/dto/response/team-response.dto";
import { TeamRequestDto } from "../model/dto/request/team-request.dto";
import { TeamUpdateRequestDto } from "../model/dto/request/team-update.request.dto";
import { TeamAndMemberResponseDto } from "../model/dto/response/team-and-member-response.dto";

@Resolver(() => TeamEntity)
export class TeamResolver {
  constructor(@Inject("TeamService") private readonly teamService: TeamService) {}

  @UsePipes(new ValidationPipe({ transform: true }))
  @Mutation(() => DefaultResponse<string>)
  async saveTeam(@Args("input", { type: () => TeamRequestDto }) @Body() teamRequestDto: TeamRequestDto): Promise<DefaultResponse<number>> {
    return this.teamService.saveTeam(teamRequestDto);
  }

  @Query(() => DefaultResponse<Promise<[TeamEntity[], number]>>)
  async getTeamList(
    @Args("manager", { type: () => String, nullable: true }) manager: string,
    @Args("office", { type: () => String, nullable: true }) office: string,
    @Args("extensionNumber", { type: () => Int, nullable: true }) extensionNumber: string,
    @Args("mascot", { type: () => Int, nullable: true }) mascot: string,
    @Args("cleaningDuty", { type: () => Int, nullable: true }) cleaningDuty: string,
    @Args("project", { type: () => Int, nullable: true }) project: string,
    @Args("pageNumber", { type: () => Int, nullable: true }) pageNumber: number,
    @Args("perPageSize", { type: () => Int, nullable: true }) perPageSize: number,
    @Args("orderBy", { type: () => Boolean, nullable: true }) orderBy: boolean,
  ): Promise<DefaultResponse<TeamResponseDto>> {
    return this.teamService.getTeamList(manager, office, extensionNumber, mascot, cleaningDuty, project, pageNumber, perPageSize, orderBy);
  }

  @Query(() => DefaultResponse<TeamResponseDto>)
  async getTeam(@Args("teamId", { type: () => String }) teamId: number): Promise<DefaultResponse<TeamResponseDto>> {
    return this.teamService.getTeam(teamId);
  }

  @Query(() => DefaultResponse<TeamAndMemberResponseDto>)
  async getTeamByTeamId(@Args("teamId", { type: () => String }) teamId: number): Promise<DefaultResponse<TeamAndMemberResponseDto>> {
    return this.teamService.getTeamByTeamId(teamId);
  }

  @UsePipes(new ValidationPipe({ transform: true }))
  @Mutation(() => DefaultResponse<string>)
  async updateTeam(
    @Args("input", { type: () => TeamUpdateRequestDto }) @Body() teamUpdateRequestDto: TeamUpdateRequestDto,
  ): Promise<DefaultResponse<number>> {
    return this.teamService.updateTeam(teamUpdateRequestDto);
  }

  @Mutation(() => Promise<DefaultResponse<string>>)
  async deleteTeam(@Args("teamId", { type: () => String }) teamId: number): Promise<DefaultResponse<number>> {
    return this.teamService.deleteTeam(teamId);
  }
}
