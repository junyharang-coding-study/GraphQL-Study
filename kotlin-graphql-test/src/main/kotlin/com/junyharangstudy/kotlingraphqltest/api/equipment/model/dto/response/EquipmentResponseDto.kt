package com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response

import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment

class EquipmentResponseDto(
    val equipmentId: String,
    val usedBy: String,
    val count: Int,
    val newOrUsed: String
) {
    companion object {
        fun equipmentToDto(equipment: Equipment): EquipmentResponseDto {
            return EquipmentResponseDto(
                equipmentId = equipment.equipmentId,
                usedBy = equipment.usedBy,
                count = equipment.count,
                newOrUsed = equipment.newOrUsed)
        }
    }
}