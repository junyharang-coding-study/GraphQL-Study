package com.junyss.graphqltest.common.util;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class GraphQLSupportUtil {

	public static <T> List<T> pageToList(Page<T> pageTypeDto) {
		if (pageTypeDto.getTotalElements() == 0 && !pageTypeDto.hasContent()) {
			return Collections.emptyList();
		}

		return pageTypeDto.getContent();
	}
}
