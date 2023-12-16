package com.junyharangstudy.kotlingraphqltest.api.people.repository

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.entity.People

interface PeopleQueryDslRepository {
    fun findBySearchAndPaging(pageRequestDto: PageRequestDto, peopleSearchRequestDto: PeopleSearchRequestDto?): List<People>
    fun findByTeamIdAndPaging(pageRequestDto: PageRequestDto, teamId: Long?): List<People>
}