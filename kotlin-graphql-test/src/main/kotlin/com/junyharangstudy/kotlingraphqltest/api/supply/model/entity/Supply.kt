package com.junyharangstudy.kotlingraphqltest.api.supply.model.entity

import com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team
import jakarta.persistence.*

@Entity
class Supply (
    @Id var supplyId: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    var team: Team
) {

    fun updateTeam(team: Team) {
        this.team = team
    }
}