package com.junyss.graphqltest.common.util;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class ObjectUtil {

	public static <T> Boolean checkObjectExistence(Page<T> targetPageObject) {
		return targetPageObject.getTotalElements() == 0 && !targetPageObject.hasContent();
	}
}
