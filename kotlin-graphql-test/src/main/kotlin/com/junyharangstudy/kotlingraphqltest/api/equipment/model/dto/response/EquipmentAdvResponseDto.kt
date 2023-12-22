package com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response

class EquipmentAdvResponseDto (
    var equipmentId: String?,
    var usedBy: String?,
    var count: Int?,
    var newOrUsed: String?,
    var useRate: Float? = 0F,
    var isNew: Boolean? = false)