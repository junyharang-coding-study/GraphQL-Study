package com.junyss.graphqltest.common.enumtype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Sex {

	male("male"),
	female("female");

	private String sex;
}
