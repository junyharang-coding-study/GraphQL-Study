package com.junyss.graphqltest.team.model.entity;

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

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String manager;
	private String office;
	private String extensionNumber;
	private String mascot;
	private String cleaningDuty;
	private String project;

	@Builder
	public static Team toEntity (
		String manager,
		String office,
		String extensionNumber,
		String mascot,
		String cleaningDuty,
		String project
	) {
		return new Team (
						null,
							manager,
							office,
							extensionNumber,
							mascot,
							cleaningDuty,
							project);
	}
}
