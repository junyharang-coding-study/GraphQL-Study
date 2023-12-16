package com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request

import com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team
import jakarta.validation.constraints.NotBlank

class TeamCreateRequestDto(
    @NotBlank val manager: String,
    @NotBlank val office: String,
    @NotBlank val extensionNumber: String,
    @NotBlank val mascot: String,
    @NotBlank val cleaningDuty: String,
    @NotBlank val project: String
) {
    fun toEntity(teamCreateRequestDto: TeamCreateRequestDto): Team {
        return Team(
            null,
            teamCreateRequestDto.manager,
            teamCreateRequestDto.office,
            teamCreateRequestDto.extensionNumber,
            teamCreateRequestDto.mascot,
            teamCreateRequestDto.cleaningDuty,
            teamCreateRequestDto.project)
    }
}