package com.junyss.graphqltest.api.team.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.junyss.graphqltest.api.team.model.dto.response.TeamAndMemberResponseDto;
import com.junyss.graphqltest.api.team.resolver.TeamResolver;
import com.junyss.graphqltest.common.constant.DefaultResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Team 관련 API", description = "Team 관련 API")
@RequiredArgsConstructor
@RestController
public class TeamRestApiController {

	private final TeamResolver teamResolver;

	@Operation(summary = "Team과 People 정보 상세 조회", description = "Team과 People 정보 상세 조회 API Router")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "OK"),
		@ApiResponse(responseCode = "404", description = "NOT FOUND DATA")
	})
	@GetMapping("/team/{teamId}")
	public DefaultResponse<TeamAndMemberResponseDto> getTeamByTeamId (@PathVariable("teamId") Long teamId) {
		return teamResolver.getTeamByTeamId(teamId);
	}
}
