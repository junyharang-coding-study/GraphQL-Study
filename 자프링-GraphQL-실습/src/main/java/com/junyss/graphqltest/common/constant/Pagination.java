package com.junyss.graphqltest.common.constant;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagination {
	// 전체 페이지 수
	private Integer totalPages;

	// 전체 데이터 개수
	private Long totalElements;

	// 현재 페이지
	private Integer page;

	// 현재 페이지 데이터 개수
	private Integer currentElements;

	public Pagination(Page<?> page) {
		this.totalPages = page.getTotalPages();
		this.totalElements = page.getTotalElements();
		this.page = page.getNumber();
		this.currentElements = page.getNumberOfElements();
	}
}
