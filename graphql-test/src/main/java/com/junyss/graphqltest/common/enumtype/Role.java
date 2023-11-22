package com.junyss.graphqltest.common.enumtype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Role {
	DEVELOPER("developer"),
	DESIGNER("designer"),
	PLANNER("planner");

	private String role;
}
