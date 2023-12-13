package com.junyharangstudy.kotlingraphqltest.api.equipment.repository

import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentResponseDto
import com.junyharangstudy.kotlingraphqltest.common.constant.PageRequestDto
import org.springframework.data.domain.Page

interface EquipmentQueryDslRepository {
    fun findBySearchAndPaging(pageRequestDto: PageRequestDto, equipmentSearchRequestDto: EquipmentSearchRequestDto): Page<EquipmentResponseDto>
}