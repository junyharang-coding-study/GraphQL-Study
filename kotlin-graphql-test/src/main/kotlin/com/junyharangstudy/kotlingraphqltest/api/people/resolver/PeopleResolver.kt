package com.junyharangstudy.kotlingraphqltest.api.people.resolver

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleCreateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleUpdateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto
import com.junyharangstudy.kotlingraphqltest.api.people.service.PeopleService
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class PeopleResolver (private val peopleService: PeopleService) {
    @MutationMapping
    fun savePeople(@Argument("input") peopleCreateRequestDto: PeopleCreateRequestDto):DefaultResponse<Long> {
        return peopleService.savePeople(peopleCreateRequestDto)
    }

    @QueryMapping
    fun getPeopleList(
        @Argument peopleSearchRequestDto: PeopleSearchRequestDto?,
        @Argument pageRequestDto: PageRequestDto?
    ): DefaultResponse<List<PeopleResponseDto>> {
        return peopleService.getPeopleList(peopleSearchRequestDto, pageRequestDto)
    }

    @QueryMapping
    fun getPeopleListByTeamId(
        @Argument teamId: Long,
        @Argument pageRequestDto: PageRequestDto?
    ): DefaultResponse<List<PeopleResponseDto>> {
        return peopleService.getPeopleListByTeamId(teamId, pageRequestDto)
    }

    @QueryMapping
    fun getPeopleByPeopleId (@Argument peopleId: Long): DefaultResponse<PeopleResponseDto> {
        return peopleService.getPeopleByPeopleId(peopleId)
    }

    @MutationMapping
    fun updatePeople(
        @Argument("peopleId") peopleId: Long,
        @Argument("input") peopleUpdateRequestDto: PeopleUpdateRequestDto
    ): DefaultResponse<Long> {
        return peopleService.updatePeople(peopleId, peopleUpdateRequestDto)
    }

    @MutationMapping
    fun deletePeople(@Argument peopleId: Long): DefaultResponse<Long> {
        return peopleService.deletePeople(peopleId)
    }
}