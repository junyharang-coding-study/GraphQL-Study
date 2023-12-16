package com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request

import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType
import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role
import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex
import com.junyharangstudy.kotlingraphqltest.api.people.model.entity.People
import com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

class PeopleCreateRequestDto (
    @NotNull @Min(1) val teamId: Long,
    @NotBlank val lastName: String,
    @NotBlank val firstName: String,
    @NotBlank val sex: Sex,
    @NotBlank val bloodType: BloodType,
    @NotNull @Min(0) val serveYears: Int,
    @NotBlank val role:Role,
    @NotBlank val hometown: String
) {
    fun toEntity(peopleCreateRequestDto: PeopleCreateRequestDto, team: Team): People {
        return People(
            null,
            team,
            peopleCreateRequestDto.lastName,
            peopleCreateRequestDto.firstName,
            peopleCreateRequestDto.sex,
            peopleCreateRequestDto.bloodType,
            peopleCreateRequestDto.serveYears,
            peopleCreateRequestDto.role,
            peopleCreateRequestDto.hometown
        )
    }
}