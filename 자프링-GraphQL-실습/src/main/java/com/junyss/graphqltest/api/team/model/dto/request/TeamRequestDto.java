package com.junyss.graphqltest.api.team.model.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TeamRequestDto {
	@NotBlank private Long teamId;
	@NotBlank private String manager;
	@NotBlank private String office;
	@NotBlank private String extensionNumber;
	private String mascot;
	@NotBlank private String cleaningDuty;
	private String project;
}
