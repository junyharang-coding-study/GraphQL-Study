package com.junyharangstudy.kotlingraphqltest.api.software.resolver

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareCreateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareUpdateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.software.model.dto.response.SoftwareResponseDto
import com.junyharangstudy.kotlingraphqltest.api.software.service.SoftwareService
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class SoftwareResolver(
    private val softwareService: SoftwareService
) {
    @MutationMapping
    fun saveSoftware(@Argument("input") softwareCreateRequestDto: SoftwareCreateRequestDto): DefaultResponse<String> {
        return softwareService.saveSoftware(softwareCreateRequestDto)
    }

    @QueryMapping
    fun getSoftwareList(
        @Argument softwareSearchRequestDto: SoftwareSearchRequestDto?,
        @Argument pageRequestDto: PageRequestDto?
    ): DefaultResponse<List<SoftwareResponseDto>> {
        return softwareService.getSoftwareList(softwareSearchRequestDto, pageRequestDto)
    }

    @QueryMapping
    fun getSoftwareBySoftwareId (@Argument softwareId: String): DefaultResponse<SoftwareResponseDto> {
        return softwareService.getSoftwareBySoftwareId(softwareId)
    }

    @MutationMapping
    fun updateSoftware(
        @Argument("softwareId") softwareId: String,  // softwareId 는 수정할 자료의 고유 ID 입니다. 수정할 자료가 없다면 예외가 발생합니다. 수정할 자료가 여러 개라면 예외가 발생합니다. 수정할 자료가 없다면 예외가 발생합니다. 수정할 자료가 여러 개라면 예외가 발생합니다. 수정할 자료
        @Argument("input") softwareUpdateRequestDto: SoftwareUpdateRequestDto
    ): DefaultResponse<String> {
        return softwareService.updateSoftware(softwareId, softwareUpdateRequestDto)
    }

    @MutationMapping
    fun deleteSoftware(@Argument softwareId: String): DefaultResponse<String> {
        return softwareService.deleteSoftware(softwareId)
    }
}