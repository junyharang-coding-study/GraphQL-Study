package com.junyharangstudy.kotlingraphqltest.api.team.resolver

import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamAndMemberResponseDto
import com.junyharangstudy.kotlingraphqltest.api.team.service.TeamService
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Team 관련 API", description = "Team 관련 API")
@RestController
class TeamRestApiController (private val teamService: TeamService) {
    @Operation(summary = "Team과 People 정보 상세 조회", description = "Team과 People 정보 상세 조회 API Router")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND DATA")
    @GetMapping("/team/{teamId}")
    fun getTeamAndMemberByTeamId(@PathVariable("teamId") teamId: Long): DefaultResponse<TeamAndMemberResponseDto> {
        return teamService.getTeamAndMemberByTeamId(teamId)
    }
}