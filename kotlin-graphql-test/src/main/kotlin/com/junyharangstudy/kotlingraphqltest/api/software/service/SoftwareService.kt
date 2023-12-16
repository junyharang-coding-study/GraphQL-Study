package com.junyharangstudy.kotlingraphqltest.api.software.service

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareCreateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareUpdateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.software.model.dto.response.SoftwareResponseDto
import com.junyharangstudy.kotlingraphqltest.api.software.model.entity.Software
import com.junyharangstudy.kotlingraphqltest.api.software.repository.SoftwareQueryDslRepository
import com.junyharangstudy.kotlingraphqltest.api.software.repository.SoftwareRepository
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse
import com.junyharangstudy.kotlingraphqltest.common.constant.Pagination
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SoftwareService (
    private val softwareRepository: SoftwareRepository,
    private val softwareQueryDslRepository: SoftwareQueryDslRepository
) {
    @Transactional
    fun saveSoftware(softwareCreateRequestDto: SoftwareCreateRequestDto): DefaultResponse<String> {
        val saveAsDbSoftwareId = softwareRepository.save(softwareCreateRequestDto.toEntity(softwareCreateRequestDto)).softwareId

        return if (saveAsDbSoftwareId == null) {
            DefaultResponse.response(HttpStatus.NO_CONTENT.value(), "Failed Create")
        } else {
            DefaultResponse.response(HttpStatus.CREATED.value(), "Success Create", saveAsDbSoftwareId)
        }
    }

    @Transactional(readOnly = true)
    fun getSoftwareList(softwareSearchRequestDto: SoftwareSearchRequestDto?, pageRequestDto: PageRequestDto?): DefaultResponse<List<SoftwareResponseDto>> {
        return when {
            pageRequestDto?.currentPage != null && pageRequestDto.perPageSize != null -> {
                when {
                    softwareSearchRequestDto != null -> processingParameterNotNull(pageRequestDto, softwareSearchRequestDto)
                    else -> processingParameterPagingNotNull(pageRequestDto)
                }
            }

            else -> {
                val findElements = processingParameterNull()

                if (findElements.isEmpty()) {
                    return DefaultResponse.response(HttpStatus.NO_CONTENT.value(), "No Content", findElements)
                }

                return DefaultResponse.response(HttpStatus.OK.value(), "OK", findElements)
            }
        }
    }

    @Transactional(readOnly = true)
    fun getSoftwareBySoftwareId(softwareId: String): DefaultResponse<SoftwareResponseDto> {
        val findById = softwareRepository.findById(softwareId)

        return if (findById.isEmpty) {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA")
        } else {
            DefaultResponse.response(HttpStatus.OK.value(), "OK", SoftwareResponseDto.softwareToDto(findById.get()))
        }
    }

    @Transactional
    fun updateSoftware(softwareId: String, softwareUpdateRequestDto: SoftwareUpdateRequestDto): DefaultResponse<String> {
        val findById = softwareRepository.findById(softwareId)

        return if (findById.isEmpty) {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET DATA")
        } else {
            val software = checkUpdateRequest(softwareUpdateRequestDto, findById.get())

            DefaultResponse.response(HttpStatus.OK.value(), "Success Update", softwareRepository.save(software).softwareId)
        }
    }

    @Transactional
    fun deleteSoftware(softwareId: String): DefaultResponse<String> {
        val findById = softwareRepository.findById(softwareId)

        return if (findById.isEmpty) {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DELETE TARGET DATA")
        } else {
            softwareRepository.deleteById(findById.get().softwareId)
            DefaultResponse.response(HttpStatus.OK.value(), "Deleted Success", findById.get().softwareId)
        }
    }

    private fun checkUpdateRequest(softwareUpdateRequestDto: SoftwareUpdateRequestDto, software: Software): Software {
        return software.apply {
            when {
                softwareUpdateRequestDto.usedBy != null -> software.updateUsedBy(softwareUpdateRequestDto.usedBy!!)
                softwareUpdateRequestDto.developedBy != null -> software.updateUsedBy(softwareUpdateRequestDto.developedBy!!)
                softwareUpdateRequestDto.description != null -> software.updateUsedBy(softwareUpdateRequestDto.description!!)
            }
        }
    }

    private fun processingParameterNotNull(
        pageRequestDto: PageRequestDto,
        softwareSearchRequestDto: SoftwareSearchRequestDto
    ): DefaultResponse<List<SoftwareResponseDto>> {
        val findElements = softwareQueryDslRepository.findBySearchAndPaging(pageRequestDto, softwareSearchRequestDto)

        return if (findElements.isEmpty()) {
            DefaultResponse.response(
                HttpStatus.NO_CONTENT.value(), "No Content",
                findElements.map { software ->
                    SoftwareResponseDto.softwareToDto(software)
                }.toList(),
            )
        } else {
            DefaultResponse.response(
                HttpStatus.OK.value(),
                "OK",
                findElements.map { software ->
                    SoftwareResponseDto.softwareToDto(software)
                }.toList(),
                Pagination(findElements.size, processingTotalElementCount(), pageRequestDto.getOrderBy())
            )
        }
    }

    private fun processingParameterPagingNotNull(pageRequestDto: PageRequestDto): DefaultResponse<List<SoftwareResponseDto>> {
        val findElements = softwareQueryDslRepository.findBySearchAndPaging(pageRequestDto, null)

        return if (findElements.isEmpty()) {
             DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA")
        } else {
            DefaultResponse.response(
                HttpStatus.OK.value(),
                "OK",
                findElements.map { software ->
                    SoftwareResponseDto.softwareToDto(software)
                }.toList(),
                Pagination(findElements.size, processingTotalElementCount(), pageRequestDto.getOrderBy())
            )
        }
    }

    private fun processingParameterNull(): List<SoftwareResponseDto> {
        return softwareRepository.findAll().mapNotNull { software -> SoftwareResponseDto.softwareToDto(software)  }
    }

    private fun processingTotalElementCount(): Int {
        return softwareRepository.findAll().count()
    }
}