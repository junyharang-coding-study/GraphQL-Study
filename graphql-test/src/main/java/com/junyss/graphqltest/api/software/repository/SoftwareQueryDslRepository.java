package com.junyss.graphqltest.api.software.repository;

import static com.junyss.graphqltest.api.software.model.entity.QSoftware.software;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.junyss.graphqltest.api.software.model.dto.request.SoftwareSearchRequestDto;
import com.junyss.graphqltest.api.software.model.dto.response.SoftwareResponseDto;
import com.junyss.graphqltest.common.util.PagingProcessUtil;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class SoftwareQueryDslRepository {

	private final JPAQueryFactory jpaQueryFactory;

	public Page<SoftwareResponseDto> findBySearchAndPaging(
		SoftwareSearchRequestDto softwareSearchRequestDto,
		Pageable pageable) {

		JPAQuery<SoftwareResponseDto> query = jpaQueryFactory.select(
				Projections.constructor(
					SoftwareResponseDto.class,
					software.softwareId,
					software.usedBy,
					software.developedBy,
					software.description))
			.from(software)
			.where(
				eqUsedBy(softwareSearchRequestDto.getUsedBy()),
				eqDevelopedBy(softwareSearchRequestDto.getDevelopedBy()))
			.orderBy(software.softwareId.desc());

		return new PageImpl<>(
			PagingProcessUtil.queryDslPagingProcessing(query, pageable),
			pageable,
			query.stream().count());
	}



	private BooleanExpression eqUsedBy(String usedBy) {
		if (!StringUtils.hasText(usedBy)) {
			return null;
		}
		return software.usedBy.eq(usedBy);
	}

	private BooleanExpression eqDevelopedBy(String developedBy) {
		if (!StringUtils.hasText(developedBy)) {
			return null;
		}
		return software.developedBy.eq(developedBy);
	}
}
