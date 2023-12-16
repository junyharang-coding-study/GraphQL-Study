package com.junyharangstudy.kotlingraphqltest.api.role.service

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleCreateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleUpdateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.role.model.dto.response.RoleResponseDto
import com.junyharangstudy.kotlingraphqltest.api.role.model.entity.Role
import com.junyharangstudy.kotlingraphqltest.api.role.repository.RoleQueryDslRepository
import com.junyharangstudy.kotlingraphqltest.api.role.repository.RoleRepository
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse
import com.junyharangstudy.kotlingraphqltest.common.constant.Pagination
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RoleService(
    private val roleRepository: RoleRepository,
    private val roleQueryDslRepository: RoleQueryDslRepository
) {
    @Transactional
    fun saveRole(roleCreateRequestDto: RoleCreateRequestDto): DefaultResponse<String> {
        val saveAsDbRoleId = roleRepository.save(roleCreateRequestDto.toEntity(roleCreateRequestDto)).roleId

        return if (saveAsDbRoleId == null) {
            DefaultResponse.response(HttpStatus.NO_CONTENT.value(), "Failed Create")
        } else {
            DefaultResponse.response(HttpStatus.CREATED.value(), "Success Create", saveAsDbRoleId)
        }
    }

    @Transactional(readOnly = true)
    fun getRoleList(roleSearchRequestDto: RoleSearchRequestDto?, pageRequestDto: PageRequestDto?): DefaultResponse<List<RoleResponseDto>> {
        return when {
            pageRequestDto?.currentPage != null && pageRequestDto.perPageSize != null -> {
                when {
                    roleSearchRequestDto != null -> processingParameterNotNull(pageRequestDto, roleSearchRequestDto)
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
    fun getRoleByRoleId(roleId: String): DefaultResponse<RoleResponseDto> {
        val findById = roleRepository.findById(roleId)

        return if (findById.isEmpty) {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA")
        } else {
            DefaultResponse.response(HttpStatus.OK.value(), "OK", RoleResponseDto.roleToDto(findById.get()))
        }
    }

    @Transactional
    fun updateRole(roleId: String, roleUpdateRequestDto: RoleUpdateRequestDto): DefaultResponse<String> {
        val findById = roleRepository.findById(roleId)

        return if (findById.isEmpty) {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET DATA")
        } else {
            val role = checkUpdateRequest(roleUpdateRequestDto, findById.get())

            DefaultResponse.response(HttpStatus.OK.value(), "Success Update", roleRepository.save(role).roleId)
        }
    }

    @Transactional
    fun deleteRole(roleId: String): DefaultResponse<String> {
        val findById = roleRepository.findById(roleId)

        return if (findById.isEmpty) {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DELETE TARGET DATA")
        } else {
            roleRepository.deleteById(findById.get().roleId)
            DefaultResponse.response(HttpStatus.OK.value(), "Deleted Success", findById.get().roleId)
        }
    }

    private fun checkUpdateRequest(roleUpdateRequestDto: RoleUpdateRequestDto, role: Role): Role {
        return role.apply {
            when {
                roleUpdateRequestDto.job != null -> role.updateJob(roleUpdateRequestDto.job!!)
                roleUpdateRequestDto.requirement != null -> role.updateRequirment(roleUpdateRequestDto.requirement!!)
            }
        }
    }

    private fun processingParameterNotNull(
        pageRequestDto: PageRequestDto,
        roleSearchRequestDto: RoleSearchRequestDto
    ): DefaultResponse<List<RoleResponseDto>> {
        val findElements = roleQueryDslRepository.findBySearchAndPaging(pageRequestDto, roleSearchRequestDto)

        return if (findElements.isEmpty()) {
            DefaultResponse.response(
                HttpStatus.NO_CONTENT.value(), "No Content",
                findElements.map { role ->
                    RoleResponseDto.roleToDto(role)
                }.toList(),
            )
        } else {
            DefaultResponse.response(
                HttpStatus.OK.value(),
                "OK",
                findElements.map { role ->
                    RoleResponseDto.roleToDto(role)
                }.toList(),
                Pagination(findElements.size, processingTotalElementCount(), pageRequestDto.getOrderBy())
            )
        }
    }

    private fun processingParameterPagingNotNull(pageRequestDto: PageRequestDto): DefaultResponse<List<RoleResponseDto>> {
        val findElements = roleQueryDslRepository.findBySearchAndPaging(pageRequestDto, null)

        return if (findElements.isEmpty()) {
            DefaultResponse.response(
                HttpStatus.NO_CONTENT.value(), "No Content",
                findElements.map { role ->
                    RoleResponseDto.roleToDto(role)
                }.toList(),
            )
        } else {
            DefaultResponse.response(
                HttpStatus.OK.value(),
                "OK",
                findElements.map { role ->
                    RoleResponseDto.roleToDto(role)
                }.toList(),
                Pagination(findElements.size, processingTotalElementCount(), pageRequestDto.getOrderBy())
            )
        }
    }

    private fun processingParameterNull(): List<RoleResponseDto> {
        return roleRepository.findAll().mapNotNull { role -> RoleResponseDto.roleToDto(role) }
    }


    private fun processingTotalElementCount(): Int {
        return roleRepository.findAll().count()
    }
}