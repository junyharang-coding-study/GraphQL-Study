package com.junyss.graphqltest.api.team.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamSearchRequestDto {
	private String manager;
	private String office;
	private String extensionNumber;
	private String mascot;
	private String cleaningDuty;
	private String project;
}
