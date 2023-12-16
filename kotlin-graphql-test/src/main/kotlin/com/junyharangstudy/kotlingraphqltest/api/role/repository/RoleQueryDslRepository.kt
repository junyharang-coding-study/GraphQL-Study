package com.junyharangstudy.kotlingraphqltest.api.role.repository

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.role.model.entity.Role

interface RoleQueryDslRepository {
    fun findBySearchAndPaging(pageRequestDto: PageRequestDto, roleSearchRequestDto: RoleSearchRequestDto?): List<Role>
}