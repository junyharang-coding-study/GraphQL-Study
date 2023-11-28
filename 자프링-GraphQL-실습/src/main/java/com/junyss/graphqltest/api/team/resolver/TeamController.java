package com.junyss.graphqltest.api.team.resolver;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.junyss.graphqltest.api.team.model.dto.request.TeamRequestDto;
import com.junyss.graphqltest.api.team.model.dto.request.TeamUpdateRequestDto;
import com.junyss.graphqltest.api.team.model.dto.response.TeamAndMemberResponseDto;
import com.junyss.graphqltest.api.team.model.dto.response.TeamResponseDto;
import com.junyss.graphqltest.api.team.service.TeamService;
import com.junyss.graphqltest.common.constant.DefaultResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamController {

	private final TeamService teamService;

	@MutationMapping
	public DefaultResponse<Long> saveForTeam (@Argument("input") TeamRequestDto teamRequestDto) {
		return teamService.saveForTeam(teamRequestDto);
	}

	@QueryMapping
	public DefaultResponse<List<TeamResponseDto>> getTeamList (
		@Argument String manager,
		@Argument String office,
		@Argument String extensionNumber,
		@Argument String mascot,
		@Argument String cleaningDuty,
		@Argument String project,
		@Argument Integer page,
		@Argument Integer size) {

		return teamService.getTeamList(
			manager,
			office,
			extensionNumber,
			mascot,
			cleaningDuty,
			project,
			page,
			size);
	}

	@QueryMapping
	public DefaultResponse<TeamAndMemberResponseDto> getTeamByTeamId (@Argument Long teamId) {
		return teamService.getTeamByTeamId(teamId);
	}

	@MutationMapping
	public DefaultResponse<Long> updateTeam (@Argument("input") TeamUpdateRequestDto teamUpdateRequestDto) {
		return teamService.updateTeam(teamUpdateRequestDto);
	}

	@MutationMapping
	public DefaultResponse<Long> deleteTeam (@Argument Long teamId) {
		return teamService.deleteTeam(teamId);
	}
}
