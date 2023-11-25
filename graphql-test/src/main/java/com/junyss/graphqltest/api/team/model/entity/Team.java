package com.junyss.graphqltest.api.team.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamId;
	private String manager;
	private String office;
	private String extensionNumber;
	private String mascot;
	private String cleaningDuty;
	private String project;

	@Builder
	public static Team toEntity(
		String manager,
		String office,
		String extensionNumber,
		String mascot,
		String cleaningDuty,
		String project
	) {
		return new Team(
			null,
			manager,
			office,
			extensionNumber,
			mascot,
			cleaningDuty,
			project);
	}

	public void updateManager(String manager) {
		this.manager = manager;
	}

	public void updateOffice(String office) {
		this.office = office;
	}

	public void updateExtensionNumber(String extensionNumber) {
		this.extensionNumber = extensionNumber;
	}

	public void updateMascot(String mascot) {
		this.mascot = mascot;
	}

	public void updateCleaningDuty(String cleaningDuty) {
		this.cleaningDuty = cleaningDuty;
	}

	public void updateProject(String project) {
		this.project = project;
	}
}
