package com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request

import com.junyharangstudy.kotlingraphqltest.api.role.model.entity.Role
import jakarta.validation.constraints.NotBlank

class RoleCreateRequestDto (
    @NotBlank val roleId: String,
    @NotBlank val job: String,
    @NotBlank val requirement: String
) {
    fun toEntity(roleCreateRequestDto: RoleCreateRequestDto): Role {
        return Role(
            roleCreateRequestDto.roleId,
            roleCreateRequestDto.job,
            roleCreateRequestDto.requirement)
    }
}