package com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response

import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team

class TeamAndMemberResponseDto (
    private val teamId: Long,
    private val manager: String,
    private val office: String,
    private val extensionNumber: String,
    private val mascot: String,
    private val cleaningDuty: String,
    private val project: String,
    private val members: List<PeopleResponseDto>
) {
    companion object {
        fun entityToDto(team: Team, peopleResponseDto: List<PeopleResponseDto>): TeamAndMemberResponseDto {
            return TeamAndMemberResponseDto (
                teamId = team.teamId!!,
                manager = team.manager,
                office = team.office,
                extensionNumber = team.extensionNumber,
                mascot = team.mascot,
                cleaningDuty = team.cleaningDuty,
                project = team.project,
                members = peopleResponseDto)
        }
    }
}