package com.junyss.graphqltest.common.enumtype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum NewOrUsed {
	NEW("new"),
	USED("used");

	private String newOrUsed;
}
