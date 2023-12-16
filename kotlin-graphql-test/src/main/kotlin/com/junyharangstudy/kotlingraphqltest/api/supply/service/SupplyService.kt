package com.junyharangstudy.kotlingraphqltest.api.supply.service

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.request.SupplyCreateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.response.SupplyResponseDto
import com.junyharangstudy.kotlingraphqltest.api.supply.model.entity.Supply
import com.junyharangstudy.kotlingraphqltest.api.supply.repository.SupplyQueryDslRepository
import com.junyharangstudy.kotlingraphqltest.api.supply.repository.SupplyRepository
import com.junyharangstudy.kotlingraphqltest.api.team.repository.TeamRepository
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse
import com.junyharangstudy.kotlingraphqltest.common.constant.Pagination
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SupplyService (
    private val supplyRepository: SupplyRepository,
    private val teamRepository: TeamRepository,
    private val supplyQueryDslRepository: SupplyQueryDslRepository
) {
    @Transactional
    fun saveSupply(supplyCreateRequestDto: SupplyCreateRequestDto): DefaultResponse<String> {
        val findTeamByTeamId = teamRepository.findById(supplyCreateRequestDto.teamId)

        if (findTeamByTeamId.isEmpty) {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "존재 하지 않는 팀 정보", supplyCreateRequestDto.teamId)
        }

        val saveAsDbRoleId = supplyRepository.save(supplyCreateRequestDto.toEntity(supplyCreateRequestDto.supplyId, findTeamByTeamId.get())).supplyId

        return if (saveAsDbRoleId == null) {
            DefaultResponse.response(HttpStatus.NO_CONTENT.value(), "Failed Create")
        } else {
            DefaultResponse.response(HttpStatus.CREATED.value(), "Success Create", saveAsDbRoleId)
        }
    }

    @Transactional(readOnly = true)
    fun getSupplyList(teamId: Long?, pageRequestDto: PageRequestDto?): DefaultResponse<List<SupplyResponseDto>> {
        return when {
            pageRequestDto?.currentPage != null && pageRequestDto.perPageSize != null -> {
                when {
                    teamId != null -> processingParameterNotNull(pageRequestDto, teamId)
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
    fun getSupplyBySupplyId(supplyId: String): DefaultResponse<SupplyResponseDto> {
        val findById = supplyRepository.findById(supplyId)

        return if (findById.isEmpty) {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA")
        } else {
            DefaultResponse.response(HttpStatus.OK.value(), "OK", SupplyResponseDto.supplyToDto(findById.get()))
        }
    }

    @Transactional
    fun updateSupply(supplyId: String, teamId: Long): DefaultResponse<String> {
        val findById = supplyRepository.findById(supplyId)

        return if (findById.isEmpty) {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET DATA")
        } else {
            val role = checkUpdateRequest(teamId, findById.get())

            DefaultResponse.response(HttpStatus.OK.value(), "Success Update", supplyRepository.save(role).supplyId)
        }
    }

    @Transactional
    fun deleteSupply(supplyId: String): DefaultResponse<String> {
        val findById = supplyRepository.findById(supplyId)

        return if (findById.isEmpty) {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DELETE TARGET DATA")
        } else {
            DefaultResponse.response(HttpStatus.OK.value(), "Deleted Success", findById.get().supplyId)
        }
    }

    private fun processingParameterNotNull(
        pageRequestDto: PageRequestDto,
        teamId: Long
    ): DefaultResponse<List<SupplyResponseDto>> {
        val findElements = supplyQueryDslRepository.findBySearchAndPaging(pageRequestDto, teamId)

        return if (findElements.isEmpty()) {
            DefaultResponse.response(
                HttpStatus.NO_CONTENT.value(), "No Content",
                findElements.map { supply ->
                    SupplyResponseDto.supplyToDto(supply)
                }.toList(),
            )
        } else {
            DefaultResponse.response(
                HttpStatus.OK.value(),
                "OK",
                findElements.map { supply ->
                    SupplyResponseDto.supplyToDto(supply)
                }.toList(),
                Pagination(findElements.size, processingTotalElementCount(), pageRequestDto.getOrderBy())
            )
        }
    }

    private fun processingParameterPagingNotNull(pageRequestDto: PageRequestDto): DefaultResponse<List<SupplyResponseDto>> {
        val findElements = supplyQueryDslRepository.findBySearchAndPaging(pageRequestDto, null)

        return if (findElements.isEmpty()) {
            DefaultResponse.response(
                HttpStatus.NO_CONTENT.value(), "No Content",
                findElements.map { supply ->
                    SupplyResponseDto.supplyToDto(supply)
                }.toList(),
            )
        } else {
            DefaultResponse.response(
                HttpStatus.OK.value(),
                "OK",
                findElements.map { supply ->
                    SupplyResponseDto.supplyToDto(supply)
                }.toList(),
                Pagination(findElements.size, processingTotalElementCount(), pageRequestDto.getOrderBy())
            )
        }
    }

    private fun processingParameterNull(): List<SupplyResponseDto> {
        return supplyRepository.findAll().mapNotNull { supply -> SupplyResponseDto.supplyToDto(supply) }
    }

    private fun checkUpdateRequest(teamId: Long, supply: Supply): Supply {
        return supply.apply {
            when {
                teamId > 0 -> {
                    val updateTargetTeam = teamRepository.findById(teamId)
                    if (!updateTargetTeam.isEmpty) {
                        supply.updateTeam(updateTargetTeam.get())
                    }
                }
            }
        }
    }

    private fun processingTotalElementCount(): Int {
        return supplyRepository.findAll().count()
    }
}