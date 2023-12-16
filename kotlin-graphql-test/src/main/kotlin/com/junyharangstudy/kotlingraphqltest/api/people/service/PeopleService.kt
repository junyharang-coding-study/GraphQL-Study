package com.junyharangstudy.kotlingraphqltest.api.people.service

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleCreateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleUpdateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse

interface PeopleService {
    fun savePeople(peopleCreateRequestDto: PeopleCreateRequestDto): DefaultResponse<Long>
    fun getPeopleList(peopleSearchRequestDto: PeopleSearchRequestDto?, pageRequestDto: PageRequestDto?): DefaultResponse<List<PeopleResponseDto>>
    fun getPeopleByPeopleId(peopleId: Long): DefaultResponse<PeopleResponseDto>
    fun getPeopleListByTeamId(teamId: Long, pageRequestDto: PageRequestDto?): DefaultResponse<List<PeopleResponseDto>>
    fun updatePeople(peopleId: Long, peopleUpdateRequestDto: PeopleUpdateRequestDto): DefaultResponse<Long>
    fun deletePeople(peopleId: Long): DefaultResponse<Long>
}