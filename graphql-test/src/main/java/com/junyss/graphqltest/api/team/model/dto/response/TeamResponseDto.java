package com.junyss.graphqltest.api.team.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponseDto {
	private Long teamId;
	private String manager;
	private String office;
	private String extensionNumber;
	private String mascot;
	private String cleaningDuty;
	private String project;
}
