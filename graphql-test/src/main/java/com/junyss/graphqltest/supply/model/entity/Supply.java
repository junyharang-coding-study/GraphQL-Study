package com.junyss.graphqltest.supply.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Supply {

	@Id private String SupplyId;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Team.class)
	@JoinColumn(name = "team_id")
	private Team team;

	@Builder
	public static Supply toEntity(String id, Team team) {
		return new Supply (id, team);
	}

	public void updateSupplyId(String supplyId) {
		SupplyId = supplyId;
	}
}
