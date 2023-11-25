package com.junyss.graphqltest.api.role.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class Role {

	@Id @GeneratedValue
	private String roleId;
	private String job;
	private String requirement;

	@Builder
	public static Role toEntity(String roleId, String job, String requirement) {
		return new Role(roleId, job, requirement);
	}

	public void updateJob(String job) {
		this.job = job;
	}

	public void updateRequirement(String requirement) {
		this.requirement = requirement;
	}
}
