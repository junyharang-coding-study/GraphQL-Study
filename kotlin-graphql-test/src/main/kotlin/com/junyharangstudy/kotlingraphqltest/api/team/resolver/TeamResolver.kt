package com.junyharangstudy.kotlingraphqltest.api.team.resolver

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamCreateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamUpdateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamAndMemberResponseDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamResponseDto
import com.junyharangstudy.kotlingraphqltest.api.team.service.TeamService
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class TeamResolver(
    private val teamService: TeamService
) {
    @MutationMapping
    fun saveTeam(@Argument("input") teamCreateRequestDto: TeamCreateRequestDto): DefaultResponse<Long> {
        return teamService.saveTeam(teamCreateRequestDto)
    }

    @QueryMapping
    fun getTeamList (
        @Argument teamSearchRequestDto: TeamSearchRequestDto?,
        @Argument pageRequestDto: PageRequestDto?
    ): DefaultResponse<List<TeamResponseDto>> {
        return teamService.getTeamList(teamSearchRequestDto, pageRequestDto)
    }

    @QueryMapping
    fun getTeamAndMemberByTeamId (@Argument teamId: Long): DefaultResponse<TeamAndMemberResponseDto> {
        return teamService.getTeamAndMemberByTeamId(teamId)
    }

    @MutationMapping
    fun updateTeam(
        @Argument("teamId") teamId: Long,
        @Argument("input") teamUpdateRequestDto: TeamUpdateRequestDto): DefaultResponse<Long> {
        return teamService.updateTeam(teamId, teamUpdateRequestDto)
    }

    @MutationMapping
    fun deleteTeam(@Argument teamId: Long): DefaultResponse<Long> {
        return teamService.deleteTeam(teamId)
    }
}