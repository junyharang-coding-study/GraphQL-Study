package com.junyharangstudy.kotlingraphqltest.api.equipment.service

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PagingRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentCreateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentUpdateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentResponseDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentResponseDto.Companion.equipmentToDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment
import com.junyharangstudy.kotlingraphqltest.api.equipment.repository.EquipmentQueryDslRepository
import com.junyharangstudy.kotlingraphqltest.api.equipment.repository.EquipmentRepository
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse
import com.junyharangstudy.kotlingraphqltest.common.constant.Pagination
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class EquipmentService(
    private val equipmentRepository: EquipmentRepository,
    private val equipmentQueryDslRepository: EquipmentQueryDslRepository
) {
    @Transactional
    fun saveEquipment(equipmentCreateRequestDto: EquipmentCreateRequestDto): DefaultResponse<String> {
        return DefaultResponse.response(
            HttpStatus.CREATED.value(),
            "Success Create",
            equipmentRepository.save(
                equipmentCreateRequestDto.toEntity(
                    equipmentCreateRequestDto
                )
            ).equipmentId
        )
    }

    @Transactional(readOnly = true)
    fun getEquipmentList(
        pagingRequestDto: PagingRequestDto?,
        equipmentSearchRequestDto: EquipmentSearchRequestDto?
    ): DefaultResponse<List<EquipmentResponseDto>> {

        if (pagingRequestDto?.currentPage != null && pagingRequestDto.perPageSize != null && equipmentSearchRequestDto != null) {
            return processingParameterNotNull(PageRequest.of(pagingRequestDto.currentPage, pagingRequestDto.perPageSize!!
            ), equipmentSearchRequestDto)
        } else if (pagingRequestDto?.currentPage != null && pagingRequestDto.perPageSize != null && equipmentSearchRequestDto == null) {
            return processingParameterPagingNotNull(pagingRequestDto)
        }

        val findElements = processingParameterNull()

        if (findElements.isEmpty()) {
            return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
        }

        return DefaultResponse.response(
            HttpStatus.OK.value(),
            "OK",
            findElements
        )
    }

    @Transactional(readOnly = true)
    fun getEquipment(equipmentId: String): DefaultResponse<EquipmentResponseDto> {
        val findById = equipmentRepository.findById(equipmentId)

        if (findById.isEmpty) {
            return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
        }

        return DefaultResponse.response(
            HttpStatus.OK.value(),
            "OK",
            equipmentToDto(findById.get())
        )
    }

    @Transactional
    fun updateEquipment(
        equipmentId: String,
        equipmentUpdateRequestDto: EquipmentUpdateRequestDto
    ): DefaultResponse<String> {
        val findById = equipmentRepository.findById(equipmentId)

        if (findById.isEmpty) {
            return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET DATA");
        }

        val equipment = checkUpdateRequest(equipmentUpdateRequestDto, findById.get())

        return DefaultResponse.response(
            HttpStatus.OK.value(),
            "Success Update",
            equipmentRepository.save(equipment).equipmentId
        )
    }

    @Transactional
    fun deleteEquipment(equipmentId: String): DefaultResponse<String> {
        val findById = equipmentRepository.findById(equipmentId)

        if (findById.isEmpty) {
            return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET DATA");
        }

        return DefaultResponse.response(HttpStatus.OK.value(), "Deleted Success", equipmentId)
    }

    private fun checkUpdateRequest(
        equipmentUpdateRequestDto: EquipmentUpdateRequestDto,
        equipment: Equipment
    ): Equipment {
        if (equipmentUpdateRequestDto.usedBy != null) {
            equipment.updateUsedBy(equipmentUpdateRequestDto.usedBy!!)
        }

        if (equipmentUpdateRequestDto.count != null) {
            equipment.updateCount(equipmentUpdateRequestDto.count!!)
        }

        if (equipmentUpdateRequestDto.newOrUsed != null) {
            equipment.updateNewOrUsed(equipmentUpdateRequestDto.newOrUsed!!)
        }

        return equipment
    }

    private fun processingParameterNotNull(
        pageable: Pageable,
        equipmentSearchRequestDto: EquipmentSearchRequestDto
    ): DefaultResponse<List<EquipmentResponseDto>> {
        val findElements = equipmentQueryDslRepository.findBySearchAndPaging(pageable, equipmentSearchRequestDto)

        if (findElements.isEmpty()) {
            return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
        }

        return DefaultResponse.response(
            HttpStatus.OK.value(),
            "OK",
            findElements.stream().filter(Objects::nonNull)
                .map {
                        equipment -> equipmentToDto(equipment)
                }.toList(),
            Pagination(findElements)
        )
    }

    private fun processingParameterPagingNotNull(pagingRequestDto: PagingRequestDto): DefaultResponse<List<EquipmentResponseDto>> {
        if (equipmentRepository.findAll().count() <= pagingRequestDto.perPageSize!!) {
            pagingRequestDto.perPageSize = equipmentRepository.findAll().count() -1
        }

        val findElements = equipmentQueryDslRepository.findBySearchAndPaging(PageRequest.of(pagingRequestDto.currentPage!!, pagingRequestDto.perPageSize!!), null)

        if (findElements.isEmpty()) {
            return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
        }

        return DefaultResponse.response(
            HttpStatus.OK.value(),
            "OK",
            findElements.stream().filter(Objects::nonNull)
                .map { equipment ->
                    equipmentToDto(equipment)
                }.toList(),
            Pagination(findElements)
        )
    }

    private fun processingParameterNull(): List<EquipmentResponseDto> {
        return equipmentRepository.findAll().stream().filter(Objects::nonNull)
            .map {
                    equipment -> equipmentToDto(equipment)
            }.toList()
    }
}