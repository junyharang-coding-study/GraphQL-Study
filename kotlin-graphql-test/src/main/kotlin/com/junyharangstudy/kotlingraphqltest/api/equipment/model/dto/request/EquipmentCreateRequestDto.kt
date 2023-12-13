package com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request

import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

class EquipmentCreateRequestDto(
    @NotBlank val equipmentId: String,
    @NotBlank val usedBy: String,
    @NotNull @Min(1) val count: Int,
    @NotBlank val newOrUsed: String
) {

    fun toEntity(equipmentCreateRequestDto: EquipmentCreateRequestDto
    ): Equipment {
        return Equipment(
            equipmentCreateRequestDto.equipmentId,
            equipmentCreateRequestDto.usedBy,
            equipmentCreateRequestDto.count,
            equipmentCreateRequestDto.newOrUsed,
        )
    }
}