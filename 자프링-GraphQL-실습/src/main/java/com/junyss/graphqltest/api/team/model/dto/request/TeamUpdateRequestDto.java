package com.junyss.graphqltest.api.team.model.dto.request;

import lombok.Data;

@Data
public class TeamUpdateRequestDto {
	private Long teamId;
	private String manager;
	private String office;
	private String extensionNumber;
	private String mascot;
	private String cleaningDuty;
	private String project;
}
