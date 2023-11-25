package com.junyss.graphqltest.supply.repository;

import static com.junyss.graphqltest.supply.model.entity.QSupply.supply;
import static com.junyss.graphqltest.team.model.entity.QTeam.team;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.junyss.graphqltest.common.util.PagingProcessUtil;
import com.junyss.graphqltest.supply.model.dto.response.SupplyResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class SupplyQueryDslRepository {

	private final JPAQueryFactory jpaQueryFactory;

	public Page<SupplyResponseDto> findByPaging(Pageable pageable) {
		JPAQuery<SupplyResponseDto> query = jpaQueryFactory.select(Projections.constructor(
				SupplyResponseDto.class,
				supply.SupplyId,
				supply.team.teamId))
			.from(supply)
			.orderBy(supply.SupplyId.desc());

		return new PageImpl<>(
			PagingProcessUtil.queryDslPagingProcessing(query, pageable),
			pageable,
			query.stream().count());
	}

	public Page<SupplyResponseDto> findBySupplyAsTeamId(Long teamId, Pageable pageable) {
		JPAQuery<SupplyResponseDto> query = jpaQueryFactory.select(
				Projections.constructor(
					SupplyResponseDto.class,
					supply.SupplyId,
					supply.team.teamId))
			.from(supply)
			.innerJoin(supply)
			.on(team.teamId.eq(supply.team.teamId))
			.where(supply.team.teamId.eq(teamId))
			.orderBy(supply.SupplyId.desc());

		return new PageImpl<>(
			PagingProcessUtil.queryDslPagingProcessing(query, pageable),
			pageable,
			query.stream().count());
	}
}
