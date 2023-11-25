package com.junyss.graphqltest.api.team.resolver;

import java.util.List;

import com.junyss.graphqltest.api.team.model.dto.request.TeamRequestDto;
import com.junyss.graphqltest.api.team.model.dto.request.TeamUpdateRequestDto;
import com.junyss.graphqltest.api.team.model.dto.response.TeamResponseDto;
import com.junyss.graphqltest.common.constant.DefaultResponse;

public interface TeamResolver {
	DefaultResponse<Long> saveForTeam(TeamRequestDto teamRequestDto);

	DefaultResponse<List<TeamResponseDto>> getTeamList(String manager, String office, String extensionNumber, String mascot, String cleaningDuty, String project, Integer page, Integer size);

	DefaultResponse<TeamResponseDto> getTeamByTeamId(Long teamId);

	DefaultResponse<Long> updateTeam(TeamUpdateRequestDto teamUpdateRequestDto);

	DefaultResponse<Long> deleteTeam(Long teamId);
}
