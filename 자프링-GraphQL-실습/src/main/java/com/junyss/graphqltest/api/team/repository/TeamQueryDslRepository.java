package com.junyss.graphqltest.api.team.repository;

import static com.junyss.graphqltest.api.team.model.entity.QTeam.team;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.junyss.graphqltest.api.team.model.dto.request.TeamSearchRequestDto;
import com.junyss.graphqltest.api.team.model.dto.response.TeamResponseDto;
import com.junyss.graphqltest.common.util.PagingProcessUtil;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class TeamQueryDslRepository {

	private final JPAQueryFactory jpaQueryFactory;

	public Page<TeamResponseDto> findBySearchAndPaging(TeamSearchRequestDto teamSearchRequestDto, Pageable pageable) {
		JPAQuery<TeamResponseDto> query = jpaQueryFactory.select(Projections.constructor(
				TeamResponseDto.class,
				team.teamId,
				team.manager,
				team.office,
				team.extensionNumber,
				team.mascot,
				team.cleaningDuty,
				team.project))
			.from(team)
			.where(
				eqManager(teamSearchRequestDto.getManager()),
				eqOffice(teamSearchRequestDto.getOffice()),
				eqExtensionNumber(teamSearchRequestDto.getExtensionNumber()),
				eqMascot(teamSearchRequestDto.getMascot()),
				eqCleaningDuty(teamSearchRequestDto.getCleaningDuty()),
				eqProject(teamSearchRequestDto.getProject()))
			.orderBy(team.teamId.desc());

		return new PageImpl<>(
			PagingProcessUtil.queryDslPagingProcessing(query, pageable),
			pageable,
			query.stream().count());
	}

	private BooleanExpression eqManager(String manager) {
		if (manager == null) {
			return null;
		}
		return team.manager.eq(manager);
	}

	private BooleanExpression eqOffice(String office) {
		if (office == null) {
			return null;
		}
		return team.office.eq(office);
	}

	private BooleanExpression eqExtensionNumber(String extensionNumber) {
		if (extensionNumber == null) {
			return null;
		}
		return team.extensionNumber.eq(extensionNumber);
	}

	private BooleanExpression eqMascot(String mascot) {
		if (mascot == null) {
			return null;
		}
		return team.mascot.eq(mascot);
	}

	private BooleanExpression eqCleaningDuty(String cleaningDuty) {
		if (cleaningDuty == null) {
			return null;
		}
		return team.cleaningDuty.eq(cleaningDuty);
	}

	private BooleanExpression eqProject(String project) {
		if (project == null) {
			return null;
		}
		return team.project.eq(project);
	}
}
