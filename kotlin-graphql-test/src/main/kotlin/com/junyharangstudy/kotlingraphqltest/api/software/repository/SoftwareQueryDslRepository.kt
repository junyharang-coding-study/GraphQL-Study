package com.junyharangstudy.kotlingraphqltest.api.software.repository

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.software.model.entity.Software

interface SoftwareQueryDslRepository {
    fun findBySearchAndPaging(pageRequestDto: PageRequestDto, softwareSearchRequestDto: SoftwareSearchRequestDto?): List<Software>
}