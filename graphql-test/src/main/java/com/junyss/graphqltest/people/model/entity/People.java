package com.junyss.graphqltest.people.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.junyss.graphqltest.common.enumtype.BloodType;
import com.junyss.graphqltest.common.enumtype.Role;
import com.junyss.graphqltest.common.enumtype.Sex;
import com.junyss.graphqltest.team.model.entity.Team;

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
	private Sex sex;
	private BloodType bloodType;
	private Integer serveYears;
	private Role role;
	private String homeTown;

	@Builder
	public static People toEntity (
		Team team,
		String lastName,
		String firstName,
		Sex sex,
		BloodType bloodType,
		Integer serveYears,
		Role role,
		String homeTown
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
			homeTown);
	}
}
