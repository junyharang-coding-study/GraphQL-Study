package com.junyss.graphqltest.people.repository;

import static com.junyss.graphqltest.people.model.entity.QPeople.people;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.junyss.graphqltest.common.enumtype.BloodType;
import com.junyss.graphqltest.common.enumtype.Role;
import com.junyss.graphqltest.common.enumtype.Sex;
import com.junyss.graphqltest.common.util.PagingProcessUtil;
import com.junyss.graphqltest.people.model.dto.request.PeopleSearchRequestDto;
import com.junyss.graphqltest.people.model.dto.response.PeopleResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Repository
public class PeopleQueryDslRepository {

	private final JPAQueryFactory jpaQueryFactory;

	public Page<PeopleResponseDto> findBySearchAndPaging(PeopleSearchRequestDto peopleSearchRequestDto, Pageable pageable) {
		JPAQuery<PeopleResponseDto> query = jpaQueryFactory.select(Projections.constructor(
				PeopleResponseDto.class,
				people.peopleId,
				people.team.teamId,
				people.lastName,
				people.firstName,
				people.sex,
				people.bloodType,
				people.serveYears,
				people.role,
				people.hometown))
			.from(people)
			.where(
				eqPeopleId(peopleSearchRequestDto.getPeopleId()),
				eqTeam(peopleSearchRequestDto.getTeamId()),
				eqLastName(peopleSearchRequestDto.getLastName()),
				eqFirstName(peopleSearchRequestDto.getFirstName()),
				eqSex(peopleSearchRequestDto.getSex()),
				eqBloodType(peopleSearchRequestDto.getBloodType()),
				eqServeYears(peopleSearchRequestDto.getServeYears()),
				eqRole(peopleSearchRequestDto.getRole()),
				eqHometown(peopleSearchRequestDto.getHometown()))
			.orderBy(people.peopleId.desc());

		return new PageImpl<>(
			PagingProcessUtil.queryDslPagingProcessing(query, pageable),
			pageable,
			query.stream().count());
	}

	private BooleanExpression eqPeopleId(Long peopleId) {
		if (peopleId == null) {
			return null;
		}
		return people.peopleId.eq(peopleId);
	}

	private BooleanExpression eqTeam(Long teamId) {
		if (teamId == null) {
			return null;
		}
		return people.team.teamId.eq(teamId);
	}

	private BooleanExpression eqLastName(String lastName) {
		if (!StringUtils.hasText(lastName)) {
			return null;
		}
		return people.lastName.eq(lastName);
	}

	private BooleanExpression eqFirstName(String firstName) {
		if (!StringUtils.hasText(firstName)) {
			return null;
		}
		return people.firstName.eq(firstName);
	}

	private BooleanExpression eqHometown(String hometown) {
		if (!StringUtils.hasText(hometown)) {
			return null;
		}
		return people.hometown.eq(hometown);
	}

	private BooleanExpression eqRole(Role role) {
		if (role == null) {
			return null;
		}
		return people.role.eq(role);
	}

	private BooleanExpression eqServeYears(Integer serveYears) {
		if (serveYears == null) {
			return null;
		}
		return people.serveYears.eq(serveYears);
	}

	private BooleanExpression eqBloodType(BloodType bloodType) {

		if (bloodType == null) {
			return null;
		}
		return people.bloodType.eq(bloodType);
	}

	private BooleanExpression eqSex(Sex sex) {
		if (sex == null) {
			return null;
		}
		return people.sex.eq(sex);
	}
}
