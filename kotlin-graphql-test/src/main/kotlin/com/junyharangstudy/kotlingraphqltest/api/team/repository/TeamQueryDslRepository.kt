package com.junyharangstudy.kotlingraphqltest.api.team.repository

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team

interface TeamQueryDslRepository {
    fun findBySearchAndPaging(pageRequestDto: PageRequestDto, teamSearchRequestDto: TeamSearchRequestDto?): List<Team>
}