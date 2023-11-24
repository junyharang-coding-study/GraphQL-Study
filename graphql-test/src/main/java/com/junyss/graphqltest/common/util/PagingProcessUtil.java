package com.junyss.graphqltest.common.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.junyss.graphqltest.equipment.model.dto.response.EquipmentResponseDto;
import com.querydsl.jpa.impl.JPAQuery;

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

	public static <T> List<T> queryDslPagingProcessing(JPAQuery<T> query, Pageable pageable) {
		List<T> result = new ArrayList<>();

		if (query.stream().count() >= 2) {
			result = query.offset(pageable.getOffset())
						  .limit(pageable.getPageSize())
						  .fetch();
		} else {
			result.add(query.fetchOne());
		}

		return result;
	}
}
