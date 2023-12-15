package com.junyharangstudy.kotlingraphqltest.api.team.service

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.QEquipment.equipment
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamCreateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamUpdateRequestDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamResponseDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamResponseDto.Companion.teamToDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team
import com.junyharangstudy.kotlingraphqltest.api.team.repository.TeamQueryDslRepository
import com.junyharangstudy.kotlingraphqltest.api.team.repository.TeamRepository
import com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse
import com.junyharangstudy.kotlingraphqltest.common.constant.Pagination
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.util.Objects

@Service
class TeamService (
    private val teamRepository: TeamRepository,
    private val teamQueryDslRepository: TeamQueryDslRepository
) {
    @Transactional
    fun saveTeam(teamCreateRequestDto: TeamCreateRequestDto): DefaultResponse<Long> {
        val saveAsDbTeamId = teamRepository.save(teamCreateRequestDto.toEntity(teamCreateRequestDto)).teamId

        if (saveAsDbTeamId == null) {
            return DefaultResponse.response(HttpStatus.NO_CONTENT.value(), "Failed Create");
        }

        return DefaultResponse.response(HttpStatus.CREATED.value(), "Success Create", saveAsDbTeamId)
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    fun getTeamList(teamSearchRequestDto: TeamSearchRequestDto?, pageRequestDto: PageRequestDto?): DefaultResponse<List<TeamResponseDto>> {
        if (pageRequestDto?.currentPage != null && pageRequestDto.perPageSize != null && teamSearchRequestDto != null) {
            return processingParameterNotNull(pageRequestDto, teamSearchRequestDto)
        } else if (pageRequestDto?.currentPage != null && pageRequestDto.perPageSize != null && teamSearchRequestDto == null) {
            return processingParameterPagingNotNull(pageRequestDto)
        }

        val findElements = processingParameterNull()

        if (findElements.isEmpty()) {
            return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
        }

        return DefaultResponse.response(
            HttpStatus.OK.value(),
            "OK",
            findElements
        )
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    fun getTeam(teamId: Long): DefaultResponse<TeamResponseDto> {
        val findById = teamRepository.findById(teamId)

        if (findById.isEmpty) {
            return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
        }

        return DefaultResponse.response(HttpStatus.OK.value(), "OK", teamToDto(findById.get()))
    }

    fun updateTeam(teamId: Long, teamUpdateRequestDto: TeamUpdateRequestDto): DefaultResponse<Long> {
        val findById = teamRepository.findById(teamId)

        if (findById.isEmpty) {
            return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET DATA");
        }

        val team = checkUpdateRequest(teamUpdateRequestDto, findById.get())

        return DefaultResponse.response(HttpStatus.OK.value(), "Success Update", teamRepository.save(team).teamId)
    }

    fun deleteTeam(teamId: Long): DefaultResponse<Long> {
        val findById = teamRepository.findById(teamId)

        if (findById.isEmpty) {
            return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET DATA");
        }

        return DefaultResponse.response(HttpStatus.OK.value(), "Deleted Success", findById.get().teamId)
    }



    private fun processingParameterNotNull(pageRequestDto: PageRequestDto, teamSearchRequestDto: TeamSearchRequestDto): DefaultResponse<List<TeamResponseDto>> {
        val findElements = teamQueryDslRepository.findBySearchAndPaging(pageRequestDto, teamSearchRequestDto)

        if (findElements.isEmpty()) {
            return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
        }

        return DefaultResponse.response(
            HttpStatus.OK.value(),
            "OK",
            findElements.stream().filter(Objects::nonNull).map {
                team -> teamToDto(team)
            }.toList(),
            Pagination(findElements.size, processingTotalElementCount()))
    }

    private fun processingParameterNull(): List<TeamResponseDto> {
        return teamRepository.findAll().stream().filter(Objects::nonNull).map {
            team -> teamToDto(team)
        }.toList()
    }

    private fun processingParameterPagingNotNull(pageRequestDto: PageRequestDto): DefaultResponse<List<TeamResponseDto>> {
        val findElements = teamQueryDslRepository.findBySearchAndPaging(pageRequestDto, null)

        if (findElements.isEmpty()) {
            return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
        }

        return DefaultResponse.response(
            HttpStatus.OK.value(),
            "OK",
            findElements.stream().filter(Objects::nonNull).map {
                team -> teamToDto(team)
            }.toList(),
            Pagination(findElements.size, processingTotalElementCount()))
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

        if (teamUpdateRequestDto.project != null ) {
            team.updateProject(teamUpdateRequestDto.project!!)
        }

        return team
    }

    private fun processingTotalElementCount(): Int {
        return teamRepository.findAll().count()
    }
}