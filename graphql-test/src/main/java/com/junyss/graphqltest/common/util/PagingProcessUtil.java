package com.junyss.graphqltest.common.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class PagingProcessUtil {

	public static Pageable processPaging(int page, int size) {
		if (page <= 0 && size <= 0) {
			page = 1;
			size = 10;
		}
		return PageRequest.of(page, size);
	}
}
