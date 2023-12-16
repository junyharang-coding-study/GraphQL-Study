package com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.response

import com.junyharangstudy.kotlingraphqltest.api.supply.model.entity.Supply

class SupplyResponseDto (
    private val supplyId: String,
    private val teamId: Long
) {
    companion object {
        fun supplyToDto(supply: Supply): SupplyResponseDto {
            return SupplyResponseDto(
                supplyId = supply.supplyId,
                teamId = supply.team.teamId!!
            )
        }
    }
}