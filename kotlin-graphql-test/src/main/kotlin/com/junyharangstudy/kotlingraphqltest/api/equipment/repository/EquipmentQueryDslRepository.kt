package com.junyharangstudy.kotlingraphqltest.api.equipment.repository

import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface EquipmentQueryDslRepository {
    fun findBySearchAndPaging(pageable: Pageable, equipmentSearchRequestDto: EquipmentSearchRequestDto?): Page<Equipment>
}