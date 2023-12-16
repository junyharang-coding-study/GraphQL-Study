package com.junyharangstudy.kotlingraphqltest.api.role.resolver

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleCreateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleUpdateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.role.model.dto.response.RoleResponseDto
import com.junyharangstudy.kotlingraphqltest.api.role.service.RoleService
import com.junyharangstudy.kotlingraphqltest.api.software.model.dto.response.SoftwareResponseDto
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class RoleResolver (private val roleService: RoleService) {
    @MutationMapping
    fun saveRole(@Argument("input") roleCreateRequestDto: RoleCreateRequestDto): DefaultResponse<String> {
        return roleService.saveRole(roleCreateRequestDto)
    }

    @QueryMapping
    fun getRoleByRoleId (@Argument roleId: String): DefaultResponse<RoleResponseDto> {
        return roleService.getRoleByRoleId(roleId)
    }

    @MutationMapping
    fun updateRole(
        @Argument("roleId") roleId: String,  // softwareId 는 수정할 자료의 고유 ID 입니다. 수정할 자료가 없다면 예외가 발생합니다. 수정할 자료가 여러 개라면 예외가 발생합니다. 수정할 자료가 없다면 예외가 발생합니다. 수정할 자료가 여러 개라면 예외가 발생합니다. 수정할 자료
        @Argument("input") roleUpdateRequestDto: RoleUpdateRequestDto
    ): DefaultResponse<String> {
        return roleService.updateRole(roleId, roleUpdateRequestDto)
    }

    @MutationMapping
    fun deleteRole(@Argument roleId: String): DefaultResponse<String> {
        return roleService.deleteRole(roleId)
    }
}