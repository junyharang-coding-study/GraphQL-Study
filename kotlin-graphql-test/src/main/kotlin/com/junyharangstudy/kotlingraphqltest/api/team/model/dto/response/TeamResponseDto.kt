package com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response

import com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team

class TeamResponseDto (
    private val teamId: Long,
    private val manager: String,
    private val office: String,
    private val extensionNumber: String,
    private val mascot: String,
    private val cleaningDuty: String,
    private val project: String
) {
    companion object {
        fun teamToDto(team: Team): TeamResponseDto {
            return TeamResponseDto(
                teamId = team.teamId!!,
                manager = team.manager,
                office = team.office,
                extensionNumber = team.extensionNumber,
                mascot = team.mascot,
                cleaningDuty = team.cleaningDuty,
                project = team.project)
        }
    }
}