package com.junyharangstudy.kotlingraphqltest.api.supply.repository

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.supply.model.entity.Supply

interface SupplyQueryDslRepository {
    fun findBySearchAndPaging(pageRequestDto: PageRequestDto, teamId: Long?): List<Supply>
}