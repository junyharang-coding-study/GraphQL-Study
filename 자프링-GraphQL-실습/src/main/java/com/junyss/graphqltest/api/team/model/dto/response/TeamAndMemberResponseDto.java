package com.junyss.graphqltest.api.team.model.dto.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.junyss.graphqltest.api.people.model.dto.response.PeopleResponseDto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeamAndMemberResponseDto {
	private Long teamId;
	private String manager;
	private String office;
	private String extensionNumber;
	private String mascot;
	private String cleaningDuty;
	private String project;
	private List<PeopleResponseDto> members;

	@Builder
	public TeamAndMemberResponseDto(Long teamId, String manager, String office, String extensionNumber, String mascot,
		String cleaningDuty, String project, List<PeopleResponseDto> peopleResponseDtos) {
		this.teamId = teamId;
		this.manager = manager;
		this.office = office;
		this.extensionNumber = extensionNumber;
		this.mascot = mascot;
		this.cleaningDuty = cleaningDuty;
		this.project = project;
		this.members = Objects.requireNonNullElseGet(peopleResponseDtos, ArrayList::new);
	}
}
