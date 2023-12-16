package com.junyharangstudy.kotlingraphqltest.api.supply.resolver

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.software.model.dto.response.SoftwareResponseDto
import com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.request.SupplyCreateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.response.SupplyResponseDto
import com.junyharangstudy.kotlingraphqltest.api.supply.service.SupplyService
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class SupplyResolver (private val supplyService: SupplyService) {
    @MutationMapping
    fun saveSupply(@Argument("input") supplyCreateRequestDto: SupplyCreateRequestDto): DefaultResponse<String> {
        return supplyService.saveSupply(supplyCreateRequestDto)
    }

    @QueryMapping
    fun getSupplyList(
        @Argument teamId: Long?,
        @Argument pageRequestDto: PageRequestDto?
    ): DefaultResponse<List<SupplyResponseDto>> {
        return supplyService.getSupplyList(teamId, pageRequestDto)
    }

    @QueryMapping
    fun getSupplyBySupplyId (@Argument supplyId: String): DefaultResponse<SupplyResponseDto> {
        return supplyService.getSupplyBySupplyId(supplyId)
    }

    @MutationMapping
    fun updateSupply(
        @Argument("supplyId") supplyId: String,
        @Argument("teamId") teamId: Long
    ): DefaultResponse<String> {
        return supplyService.updateSupply(supplyId, teamId)
    }

    @MutationMapping
    fun deleteSupply(@Argument supplyId: String): DefaultResponse<String> {
        return supplyService.deleteSupply(supplyId)
    }
}