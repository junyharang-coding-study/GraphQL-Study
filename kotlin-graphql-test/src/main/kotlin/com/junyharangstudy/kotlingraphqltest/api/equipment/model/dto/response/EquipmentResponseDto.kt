package com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response

import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment

class EquipmentResponseDto(
    private val equipmentId: String,
    private val usedBy: String,
    private val count: Int,
    private val newOrUsed: String
) {
    companion object {
        fun equipmentToDto(equipment: Equipment): EquipmentResponseDto {
            return EquipmentResponseDto(
                equipmentId = equipment.equipmentId,
                usedBy = equipment.usedBy,
                count = equipment.count,
                newOrUsed = equipment.newOrUsed
            )
        }
    }
}