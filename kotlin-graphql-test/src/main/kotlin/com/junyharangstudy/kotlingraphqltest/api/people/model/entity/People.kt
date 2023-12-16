package com.junyharangstudy.kotlingraphqltest.api.people.model.entity

import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType
import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role
import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex
import com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team
import jakarta.persistence.*

@Entity
class People (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var peopleId: Long?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    var team: Team,

    var lastName: String,
    var firstName: String,

    @Enumerated(EnumType.STRING)
    var sex: Sex,

    @Enumerated(EnumType.STRING)
    var bloodType: BloodType,

    var serveYears: Int,

    @Enumerated(EnumType.STRING)
    var role: Role,

    var hometown: String
) {
    fun updateTeam(team: Team) {
        this.team = team
    }

    fun updateLastName(lastName: String) {
        this.lastName = lastName
    }

    fun updateFirstName(firstName: String) {
        this.firstName = firstName
    }

    fun updateSex(sex: Sex) {
        this.sex = sex
    }

    fun updateBloodType(bloodType: BloodType) {
        this.bloodType = bloodType
    }

    fun updateServeYears(serveYears: Int) {
        this.serveYears = serveYears
    }

    fun updateRole(role: Role) {
        this.role = role
    }

    fun updateHomeTown(hometown: String) {
        this.hometown = hometown
    }
}