package com.junyharangstudy.kotlingraphqltest.api.people.service

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleCreateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleUpdateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.entity.People
import com.junyharangstudy.kotlingraphqltest.api.people.repository.PeopleQueryDslRepository
import com.junyharangstudy.kotlingraphqltest.api.people.repository.PeopleRepository
import com.junyharangstudy.kotlingraphqltest.api.role.model.entity.QRole.role
import com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.response.SupplyResponseDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.entity.QTeam.team
import com.junyharangstudy.kotlingraphqltest.api.team.repository.TeamRepository
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse
import com.junyharangstudy.kotlingraphqltest.common.constant.Pagination
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PeopleServiceImpl(
    private val peopleRepository: PeopleRepository,
    private val teamRepository: TeamRepository,
    private val peopleQueryDslRepository: PeopleQueryDslRepository
) : PeopleService {
    @Transactional
    override fun savePeople(peopleCreateRequestDto: PeopleCreateRequestDto): DefaultResponse<Long> {
        val findTeamByTeamId = teamRepository.findById(peopleCreateRequestDto.teamId)

        if (findTeamByTeamId.isEmpty) {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "존재 하지 않는 팀 정보", peopleCreateRequestDto.teamId)
        }

        val saveAsPeopleId = peopleRepository.save(
            peopleCreateRequestDto.toEntity(
                peopleCreateRequestDto,
                findTeamByTeamId.get()
            )
        ).peopleId

        return if (saveAsPeopleId == null) {
            DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed Create")
        } else {
            DefaultResponse.response(HttpStatus.CREATED.value(), "Success Create", saveAsPeopleId)
        }
    }

    @Transactional(readOnly = true)
    override fun getPeopleList(
        peopleSearchRequestDto: PeopleSearchRequestDto?,
        pageRequestDto: PageRequestDto?
    ): DefaultResponse<List<PeopleResponseDto>> {
        return when {
            pageRequestDto?.currentPage != null && pageRequestDto.perPageSize != null -> {
                when {
                    peopleSearchRequestDto != null -> processingParameterNotNull(
                        pageRequestDto,
                        peopleSearchRequestDto,
                        null
                    )

                    else -> processingParameterPagingNotNull(pageRequestDto)
                }
            }

            else -> {
                val findElements = processingParameterNull()

                if (findElements.isEmpty()) {
                    return DefaultResponse.response(HttpStatus.NO_CONTENT.value(), "No Content", findElements)
                }

                return DefaultResponse.response(HttpStatus.OK.value(), "OK", findElements)
            }
        }
    }

    override fun getPeopleListByTeamId(
        teamId: Long,
        pageRequestDto: PageRequestDto?
    ): DefaultResponse<List<PeopleResponseDto>> {
        return when {
            pageRequestDto?.currentPage != null && pageRequestDto.perPageSize != null -> {
                processingParameterNotNull(pageRequestDto, null, teamId)
            }

            else -> {
                val findElements = processingParameterNull()

                if (findElements.isEmpty()) {
                    return DefaultResponse.response(HttpStatus.NO_CONTENT.value(), "No Content", findElements)
                }

                return DefaultResponse.response(HttpStatus.OK.value(), "OK", findElements)
            }
        }
    }

    @Transactional(readOnly = true)
    override fun getPeopleByPeopleId(peopleId: Long): DefaultResponse<PeopleResponseDto> {
        val findById = peopleRepository.findById(peopleId)

        return if (findById.isEmpty) {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA")
        } else {
            DefaultResponse.response(HttpStatus.OK.value(), "OK", PeopleResponseDto.peopleToDto(findById.get()))
        }
    }

    @Transactional
    override fun updatePeople(peopleId: Long, peopleUpdateRequestDto: PeopleUpdateRequestDto): DefaultResponse<Long> {
        val findById = peopleRepository.findById(peopleId)

        return if (findById.isEmpty) {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET DATA")
        } else {
            val people = checkUpdateRequest(peopleUpdateRequestDto, findById.get())

            DefaultResponse.response(HttpStatus.OK.value(), "Success Update", peopleRepository.save(people).peopleId)
        }
    }

    @Transactional
    override fun deletePeople(peopleId: Long): DefaultResponse<Long> {
        return peopleRepository.findById(peopleId).map { people ->
            peopleRepository.delete(people)
            DefaultResponse.response(HttpStatus.OK.value(), "Deleted Success", peopleId)
        }.orElseGet {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET DATA")
        }
    }

    private fun processingParameterNotNull(
        pageRequestDto: PageRequestDto,
        peopleSearchRequestDto: PeopleSearchRequestDto?,
        teamId: Long?
    ): DefaultResponse<List<PeopleResponseDto>> {
        when {
            peopleSearchRequestDto != null && teamId == null -> {
                val findElements =
                    peopleQueryDslRepository.findBySearchAndPaging(pageRequestDto, peopleSearchRequestDto)

                return if (findElements.isEmpty()) {
                    DefaultResponse.response(
                        HttpStatus.NO_CONTENT.value(), "No Content",
                        findElements.map { people ->
                            PeopleResponseDto.peopleToDto(people)
                        }.toList(),
                    )
                } else {
                    DefaultResponse.response(
                        HttpStatus.OK.value(),
                        "OK",
                        findElements.map { people ->
                            PeopleResponseDto.peopleToDto(people)
                        }.toList(),
                        Pagination(findElements.size, processingTotalElementCount(), pageRequestDto.getOrderBy())
                    )
                }
            } else -> {
                val findElements = peopleQueryDslRepository.findByTeamIdAndPaging(pageRequestDto, teamId)

                return if (findElements.isEmpty()) {
                    DefaultResponse.response(
                        HttpStatus.NO_CONTENT.value(), "No Content",
                        findElements.map { people ->
                            PeopleResponseDto.peopleToDto(people)
                        }.toList(),
                    )
                } else {
                    DefaultResponse.response(
                        HttpStatus.OK.value(),
                        "OK",
                        findElements.map { people ->
                            PeopleResponseDto.peopleToDto(people)
                        }.toList(),
                        Pagination(findElements.size, processingTotalElementCount(), pageRequestDto.getOrderBy())
                    )
                }
            }
        }

    }

    private fun processingParameterPagingNotNull(pageRequestDto: PageRequestDto): DefaultResponse<List<PeopleResponseDto>> {
        val findElements = peopleQueryDslRepository.findBySearchAndPaging(pageRequestDto, null)

        return if (findElements.isEmpty()) {
            DefaultResponse.response(
                HttpStatus.NO_CONTENT.value(), "No Content",
                findElements.map { people ->
                    PeopleResponseDto.peopleToDto(people)
                }.toList(),
            )
        } else {
            DefaultResponse.response(
                HttpStatus.OK.value(),
                "OK",
                findElements.map { people ->
                    PeopleResponseDto.peopleToDto(people)
                }.toList(),
                Pagination(findElements.size, processingTotalElementCount(), pageRequestDto.getOrderBy())
            )
        }
    }

    private fun processingParameterNull(): List<PeopleResponseDto> {
        return peopleRepository.findAll().mapNotNull { people -> PeopleResponseDto.peopleToDto(people) }
    }

    private fun checkUpdateRequest(peopleUpdateRequestDto: PeopleUpdateRequestDto, people: People): People {
        return people.apply {
            when {
                peopleUpdateRequestDto.lastName != null -> people.updateLastName(peopleUpdateRequestDto.lastName!!)
                peopleUpdateRequestDto.firstName != null -> people.updateFirstName(peopleUpdateRequestDto.firstName!!)
                peopleUpdateRequestDto.sex != null -> people.updateSex(peopleUpdateRequestDto.sex!!)
                peopleUpdateRequestDto.bloodType != null -> people.updateBloodType(peopleUpdateRequestDto.bloodType!!)
                peopleUpdateRequestDto.serveYears != null -> people.updateServeYears(peopleUpdateRequestDto.serveYears!!)
                peopleUpdateRequestDto.role != null -> people.updateRole(peopleUpdateRequestDto.role!!)
                peopleUpdateRequestDto.hometown != null -> people.updateHomeTown(peopleUpdateRequestDto.hometown!!)
            }
        }
    }

    private fun processingTotalElementCount(): Int {
        return peopleRepository.findAll().count()
    }
}