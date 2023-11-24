package com.junyss.graphqltest.common.enumtype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum BloodType {
	A("A"),
	B("B"),
	O("O"),
	AB("AB");

	private String bloodType;
}
