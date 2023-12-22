package com.junyharangstudy.kotlingraphqltest.api.equipment.resolver

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentCreateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentUpdateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentAdvResponseDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentResponseDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.service.EquipmentService
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class EquipmentResolver (
    private val equipmentService: EquipmentService
) {
    /**
     * @MuationMapping은 REST API 구축 시 @PostMapping과 같은 어노테이션으로 graphql의 Mutaion에 사용.
     * GraphQL은 Endpoint가 하나이기 때문에 @MutaionMapping만 지정하고, 다른 설정을 해 줄 필요가 없음.
     */

    @MutationMapping
    fun saveEquipment(@Argument("input") equipmentCreateRequestDto: EquipmentCreateRequestDto): DefaultResponse<String> {
        return equipmentService.saveEquipment(equipmentCreateRequestDto)
    }

    /**
     * @QueryMapping도 Rest API 구축 시 @GetMapping과 같은 어노테이션이며, @SubscriptionMapping도 존재
     */

    @QueryMapping
    fun getEquipmentList (
        @Argument equipmentSearchRequestDto: EquipmentSearchRequestDto?,
        @Argument pageRequestDto: PageRequestDto?,
    ): DefaultResponse<List<EquipmentResponseDto>> {
        return equipmentService.getEquipmentList(pageRequestDto, equipmentSearchRequestDto)
    }

    @QueryMapping
    fun getEquipmentsAdv (
        @Argument equipmentSearchRequestDto: EquipmentSearchRequestDto?,
        @Argument pageRequestDto: PageRequestDto?
    ): DefaultResponse<List<EquipmentAdvResponseDto>> {
        return equipmentService.getEquipmentAdv(pageRequestDto, equipmentSearchRequestDto)
    }

    @QueryMapping
    fun getEquipment (@Argument equipmentId: String): DefaultResponse<EquipmentResponseDto> {
        return equipmentService.getEquipment(equipmentId)
    }

    @MutationMapping
    fun updateEquipment (
        @Argument("equipmentId") equipmentId: String,
        @Argument("input") equipmentUpdateRequestDto: EquipmentUpdateRequestDto): DefaultResponse<String> {
        return equipmentService.updateEquipment(equipmentId, equipmentUpdateRequestDto)
    }

    @MutationMapping
    fun deleteEquipment (@Argument equipmentId: String): DefaultResponse<String> {
        return equipmentService.deleteEquipment(equipmentId)
    }
}