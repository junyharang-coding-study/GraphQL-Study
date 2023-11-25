package com.junyss.graphqltest.api.people.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.junyss.graphqltest.common.enumtype.BloodType;
import com.junyss.graphqltest.common.enumtype.Role;
import com.junyss.graphqltest.common.enumtype.Sex;
import com.junyss.graphqltest.api.team.model.entity.Team;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class People {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long peopleId;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Team.class)
	@JoinColumn(name = "team_id")
	private Team team;
	private String lastName;
	private String firstName;
	@Enumerated(EnumType.STRING) private Sex sex;
	@Enumerated(EnumType.STRING) private BloodType bloodType;
	private Integer serveYears;
	@Enumerated(EnumType.STRING) private Role role;
	private String hometown;

	@Builder
	public static People toEntity (
		Team team,
		String lastName,
		String firstName,
		Sex sex,
		BloodType bloodType,
		Integer serveYears,
		Role role,
		String hometown
	) {
		return new People (
			null,
			team,
			lastName,
			firstName,
			sex,
			bloodType,
			serveYears,
			role,
			hometown);
	}

	public void updatePeopleId(Long peopleId) {
		this.peopleId = peopleId;
	}

	public void updateTeam(Team team) {
		this.team = team;
	}

	public void updateLastName(String lastName) {
		this.lastName = lastName;
	}

	public void updateFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void updateSex(Sex sex) {
		this.sex = sex;
	}

	public void updateBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	public void updateServeYears(Integer serveYears) {
		this.serveYears = serveYears;
	}

	public void updateRole(Role role) {
		this.role = role;
	}

	public void updateHomeTown(String hometown) {
		this.hometown = hometown;
	}
}
