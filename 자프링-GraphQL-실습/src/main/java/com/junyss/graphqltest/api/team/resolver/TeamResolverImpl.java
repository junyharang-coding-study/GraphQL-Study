package com.junyss.graphqltest.api.team.resolver;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junyss.graphqltest.api.team.model.dto.request.TeamRequestDto;
import com.junyss.graphqltest.api.team.model.dto.request.TeamSearchRequestDto;
import com.junyss.graphqltest.api.team.model.dto.request.TeamUpdateRequestDto;
import com.junyss.graphqltest.api.team.model.dto.response.TeamResponseDto;
import com.junyss.graphqltest.api.team.model.entity.Team;
import com.junyss.graphqltest.api.team.repository.TeamQueryDslRepository;
import com.junyss.graphqltest.api.team.repository.TeamRepository;
import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.common.constant.Pagination;
import com.junyss.graphqltest.common.util.GraphQLSupportUtil;
import com.junyss.graphqltest.common.util.ObjectUtil;
import com.junyss.graphqltest.common.util.PagingProcessUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamResolverImpl implements TeamResolver{

	private final TeamRepository teamRepository;
	private final TeamQueryDslRepository teamQueryDslRepository;

	@Transactional
	@Override
	public DefaultResponse<Long> saveForTeam(TeamRequestDto teamRequestDto) {
		if (teamRequestDto == null) {
			return DefaultResponse.response(HttpStatus.NO_CONTENT.value(), "Failed Create");
		}

		return DefaultResponse.response(
			HttpStatus.CREATED.value(),
			"Success Create",
			teamRepository.save(
					Team.toEntity(
						teamRequestDto.getManager(),
						teamRequestDto.getOffice(),
						teamRequestDto.getExtensionNumber(),
						teamRequestDto.getMascot(),
						teamRequestDto.getCleaningDuty(),
						teamRequestDto.getProject()))
				.getTeamId());
	}

	@Transactional(readOnly = true)
	@Override
	public DefaultResponse<List<TeamResponseDto>> getTeamList(
		String manager,
		String office,
		String extensionNumber,
		String mascot,
		String cleaningDuty,
		String project,
		Integer page,
		Integer size) {

		Page<TeamResponseDto> result = teamQueryDslRepository.findBySearchAndPaging(
			new TeamSearchRequestDto(
				manager,
				office,
				extensionNumber,
				mascot,
				cleaningDuty,
				project),
			PagingProcessUtil.processPaging(page, size));

		if (ObjectUtil.checkObjectExistence(result)) {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}

		List<TeamResponseDto> teamResponseDtoList = GraphQLSupportUtil.pageToList(result);

		if (!teamResponseDtoList.isEmpty()) {
			return DefaultResponse.response(
				HttpStatus.OK.value(),
				"OK",
				teamResponseDtoList,
				new Pagination(result));
		} else {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}
	}

	@Transactional(readOnly = true)
	@Override
	public DefaultResponse<TeamResponseDto> getTeamByTeamId(Long teamId) {
		Optional<Team> findByTeamAsTeamId = teamRepository.findById(teamId);

		if (findByTeamAsTeamId.isPresent()) {
			Team team = findByTeamAsTeamId.get();

			return DefaultResponse.response(
				HttpStatus.OK.value(),
				"OK",
				TeamResponseDto.builder()
					.teamId(team.getTeamId())
					.manager(team.getManager())
					.office(team.getOffice())
					.extensionNumber(team.getExtensionNumber())
					.mascot(team.getMascot())
					.cleaningDuty(team.getCleaningDuty())
					.project(team.getProject())
					.build());
		}

		return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
	}

	@Transactional
	@Override
	public DefaultResponse<Long> updateTeam(TeamUpdateRequestDto teamUpdateRequestDto) {
		Optional<Team> teamRepositoryById = teamRepository.findById(teamUpdateRequestDto.getTeamId());

		Team team = checkUpdateRequest(teamUpdateRequestDto, teamRepositoryById);

		if (team == null) {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET");
		}

		return DefaultResponse.response(
			HttpStatus.OK.value(),
			"Success Update",
			teamRepository.save(team).getTeamId());
	}

	@Transactional
	@Override
	public DefaultResponse<Long> deleteTeam(Long teamId) {
		Optional<Team> teamRepositoryById = teamRepository.findById(teamId);

		if (teamRepositoryById.isPresent()) {
			teamRepository.deleteById(teamId);

			return DefaultResponse.response(HttpStatus.OK.value(), "Deleted Success", teamId);
		}

		return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DELETE TARGET", teamId);
	}

	private Team checkUpdateRequest(TeamUpdateRequestDto teamUpdateRequestDto, Optional<Team> teamRepositoryById) {
		if (teamRepositoryById.isEmpty() || teamUpdateRequestDto.getTeamId() == null) {
			return null;
		} else {
			Team team = teamRepositoryById.get();

			if (teamUpdateRequestDto.getManager() != null) {
				team.updateManager(teamUpdateRequestDto.getManager());
			}

			if (teamUpdateRequestDto.getOffice() != null) {
				team.updateOffice(teamUpdateRequestDto.getOffice());
			}

			if (teamUpdateRequestDto.getExtensionNumber() != null) {
				team.updateExtensionNumber(teamUpdateRequestDto.getExtensionNumber());
			}

			if (teamUpdateRequestDto.getMascot() != null) {
				team.updateMascot(teamUpdateRequestDto.getMascot());
			}

			if (teamUpdateRequestDto.getCleaningDuty() != null) {
				team.updateCleaningDuty(teamUpdateRequestDto.getCleaningDuty());
			}

			if (teamUpdateRequestDto.getProject() != null) {
				team.updateProject(teamUpdateRequestDto.getProject());
			}

			return team;
		}
	}
}
