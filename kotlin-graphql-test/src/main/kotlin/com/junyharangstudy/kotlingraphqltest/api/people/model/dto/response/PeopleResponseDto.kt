package com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response

import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType
import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role
import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex
import com.junyharangstudy.kotlingraphqltest.api.people.model.entity.People

class PeopleResponseDto (
    private val peopleId: Long,
    private val teamId: Long,
    private val lastName: String,
    private val firstName: String,
    private val sex: Sex,
    private val bloodType: BloodType,
    private val serveYears: Int,
    private val role: Role,
    private val hometown: String
) {
    companion object {
        fun peopleToDto(people: People): PeopleResponseDto {
            return PeopleResponseDto(
                peopleId = people.peopleId!!,
                teamId = people.team.teamId!!,
                lastName = people.lastName,
                firstName = people.firstName,
                sex = people.sex,
                bloodType = people.bloodType,
                serveYears = people.serveYears,
                role = people.role,
                hometown = people.hometown
            )
        }
    }
}