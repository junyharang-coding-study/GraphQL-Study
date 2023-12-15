package com.junyharangstudy.kotlingraphqltest.api.equipment.repository

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment

interface EquipmentQueryDslRepository {
    fun findBySearchAndPaging(pageRequestDto: PageRequestDto, equipmentSearchRequestDto: EquipmentSearchRequestDto?): List<Equipment>
}