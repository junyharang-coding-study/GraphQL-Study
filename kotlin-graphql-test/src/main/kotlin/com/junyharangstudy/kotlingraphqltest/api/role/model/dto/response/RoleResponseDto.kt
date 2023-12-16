package com.junyharangstudy.kotlingraphqltest.api.role.model.dto.response

import com.junyharangstudy.kotlingraphqltest.api.role.model.entity.Role

class RoleResponseDto (
    private val roleId: String,
    private val job: String,
    private val requirement: String
) {
    companion object {
        fun roleToDto(role: Role): RoleResponseDto {
            return RoleResponseDto(
                roleId = role.roleId,
                job = role.job,
                requirement = role.requirement)
        }
    }
}