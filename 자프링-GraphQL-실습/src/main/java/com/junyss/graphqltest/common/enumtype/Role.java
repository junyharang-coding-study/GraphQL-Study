package com.junyss.graphqltest.common.enumtype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Role {
	developer("developer"),
	designer("designer"),
	planner("planner");

	private String role;
}
