package com.junyss.graphqltest.common.enumtype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum BloodType {
	A_TYPE("A"),
	B_TYPE("B"),
	O_TYPE("O"),
	AB_TYPE("AB");

	private String bloodType;
}
