package com.junyharangstudy.kotlingraphqltest.api.equipment.service

import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentCreateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentUpdateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentResponseDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.equipmentToDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment
import com.junyharangstudy.kotlingraphqltest.api.equipment.repository.EquipmentQueryDslRepository
import com.junyharangstudy.kotlingraphqltest.api.equipment.repository.EquipmentRepository
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

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
                    equipmentCreateRequestDto)
            ).equipmentId
        )
    }

    fun getEquipmentList(equipmentSearchRequestDto: EquipmentSearchRequestDto, pageRequestDto: PageRequestDto): DefaultResponse<List<EquipmentResponseDto>> {
        equipmentQueryDslRepository.findBySearchAndPaging(pageRequestDto, equipmentSearchRequestDto)
    }

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

    fun updateEquipment(equipmentId: String, equipmentUpdateRequestDto: EquipmentUpdateRequestDto): DefaultResponse<String> {
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

    fun deleteEquipment(equipmentId: String): DefaultResponse<String> {
        val findById = equipmentRepository.findById(equipmentId)

        if (findById.isEmpty) {
            return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET DATA");
        }

        return DefaultResponse.response(HttpStatus.OK.value(), "Deleted Success", equipmentId)
    }

    private fun checkUpdateRequest(equipmentUpdateRequestDto: EquipmentUpdateRequestDto, equipment: Equipment): Equipment {
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
}