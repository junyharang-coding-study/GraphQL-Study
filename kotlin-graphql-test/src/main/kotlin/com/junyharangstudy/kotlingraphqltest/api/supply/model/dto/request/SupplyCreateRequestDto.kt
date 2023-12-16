package com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.request

import com.junyharangstudy.kotlingraphqltest.api.supply.model.entity.Supply
import com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

class SupplyCreateRequestDto (
    @NotBlank val supplyId: String,
    @NotNull @Min(1) val teamId: Long
) {
    fun toEntity(supplyId: String, team: Team): Supply {
        return Supply(supplyId, team)
    }
}