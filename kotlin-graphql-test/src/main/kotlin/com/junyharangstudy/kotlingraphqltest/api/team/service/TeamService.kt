package com.junyharangstudy.kotlingraphqltest.api.team.service

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.entity.People
import com.junyharangstudy.kotlingraphqltest.api.people.repository.PeopleRepository
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamCreateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamUpdateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamAndMemberResponseDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamResponseDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamResponseDto.Companion.teamToDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.entity.QTeam.team
import com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team
import com.junyharangstudy.kotlingraphqltest.api.team.repository.TeamQueryDslRepository
import com.junyharangstudy.kotlingraphqltest.api.team.repository.TeamRepository
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse
import com.junyharangstudy.kotlingraphqltest.common.constant.Pagination
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class TeamService(
    private val teamRepository: TeamRepository,
    private val teamQueryDslRepository: TeamQueryDslRepository,
    private val peopleRepository: PeopleRepository
) {
    @Transactional
    fun saveTeam(teamCreateRequestDto: TeamCreateRequestDto): DefaultResponse<Long> {
        val saveAsDbTeamId = teamRepository.save(teamCreateRequestDto.toEntity(teamCreateRequestDto)).teamId

        return if (saveAsDbTeamId == null) {
            DefaultResponse.response(HttpStatus.NO_CONTENT.value(), "Failed Create");
        } else {
            DefaultResponse.response(HttpStatus.CREATED.value(), "Success Create", saveAsDbTeamId)
        }
    }

    @Transactional(readOnly = true)
    fun getTeamList(
        teamSearchRequestDto: TeamSearchRequestDto?,
        pageRequestDto: PageRequestDto?
    ): DefaultResponse<List<TeamResponseDto>> {
        return when {
            pageRequestDto?.currentPage != null && pageRequestDto.perPageSize != null -> {
                when {
                    teamSearchRequestDto != null -> processingParameterNotNull(pageRequestDto, teamSearchRequestDto)
                    else -> processingParameterPagingNotNull(pageRequestDto)
                }
            }

            else -> {
                val findElements = processingParameterNull()

                if (findElements.isEmpty()) {
                    return DefaultResponse.response(HttpStatus.NO_CONTENT.value(), "No Content", findElements)
                }

                return DefaultResponse.response(
                    HttpStatus.OK.value(),
                    "OK",
                    findElements
                )
            }
        }
    }

    @Transactional(readOnly = true)
    fun getTeamAndMemberByTeamId(teamId: Long): DefaultResponse<TeamAndMemberResponseDto> {
        val findTeamByTeamId = teamRepository.findById(teamId)

        return if (findTeamByTeamId.isEmpty) {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");

        } else {
            val findAllMemberByTeamId = peopleRepository.findAllByTeamId(teamId)

            DefaultResponse.response(
                HttpStatus.OK.value(),
                "OK",
                TeamAndMemberResponseDto.entityToDto(findTeamByTeamId.get(),
                    findAllMemberByTeamId.map { people ->
                        PeopleResponseDto.peopleToDto(people)
            }))
        }
    }

    @Transactional
    fun updateTeam(teamId: Long, teamUpdateRequestDto: TeamUpdateRequestDto): DefaultResponse<Long> {
        val findById = teamRepository.findById(teamId)

        return findById.map {
            val updatedTeam = checkUpdateRequest(teamUpdateRequestDto, findById.get())
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "Success Update", teamRepository.save(updatedTeam).teamId)
        }.orElseGet {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET DATA")
        }
    }

    @Transactional
    fun deleteTeam(teamId: Long): DefaultResponse<Long> {
        return teamRepository.findById(teamId).map { team ->
            teamRepository.delete(team)
            DefaultResponse.response(HttpStatus.OK.value(), "Deleted Success", team.teamId)
        }.orElseGet {
            DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET DATA")
        }
    }


    private fun processingParameterNotNull(
        pageRequestDto: PageRequestDto,
        teamSearchRequestDto: TeamSearchRequestDto
    ): DefaultResponse<List<TeamResponseDto>> {
        val findElements = teamQueryDslRepository.findBySearchAndPaging(pageRequestDto, teamSearchRequestDto)

        return if (findElements.isEmpty()) {
            DefaultResponse.response(
                HttpStatus.NO_CONTENT.value(), "No Content",
                findElements.map { team ->
                    teamToDto(team)
                }.toList(),
            );
        } else {
            DefaultResponse.response(
                HttpStatus.OK.value(),
                "OK",
                findElements.map { team ->
                    teamToDto(team)
                }.toList(),
                Pagination(findElements.size, processingTotalElementCount(), pageRequestDto.getOrderBy())
            )
        }
    }

    private fun processingParameterNull(): List<TeamResponseDto> {
        return teamRepository.findAll().mapNotNull { team -> teamToDto(team) }
    }

    private fun processingParameterPagingNotNull(pageRequestDto: PageRequestDto): DefaultResponse<List<TeamResponseDto>> {
        val findElements = teamQueryDslRepository.findBySearchAndPaging(pageRequestDto, null)

        if (findElements.isEmpty()) {
            return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
        }

        return DefaultResponse.response(
            HttpStatus.OK.value(),
            "OK",
            findElements.map { team ->
                teamToDto(team)
            }.toList(),
            Pagination(findElements.size, processingTotalElementCount(), pageRequestDto.getOrderBy())
        )
    }

    private fun checkUpdateRequest(teamUpdateRequestDto: TeamUpdateRequestDto, team: Team): Team {
        if (teamUpdateRequestDto.manager != null) {
            team.updateManager(teamUpdateRequestDto.manager!!)
        }

        if (teamUpdateRequestDto.office != null) {
            team.updateOffice(teamUpdateRequestDto.office!!)
        }

        if (teamUpdateRequestDto.extensionNumber != null) {
            team.updateExtensionNumber(teamUpdateRequestDto.extensionNumber!!)
        }

        if (teamUpdateRequestDto.mascot != null) {
            team.updateMascot(teamUpdateRequestDto.mascot!!)
        }

        if (teamUpdateRequestDto.cleaningDuty != null) {
            team.updateCleaningDuty(teamUpdateRequestDto.cleaningDuty!!)
        }

        if (teamUpdateRequestDto.project != null) {
            team.updateProject(teamUpdateRequestDto.project!!)
        }

        return team
    }

    private fun processingTotalElementCount(): Int {
        return teamRepository.findAll().count()
    }
}