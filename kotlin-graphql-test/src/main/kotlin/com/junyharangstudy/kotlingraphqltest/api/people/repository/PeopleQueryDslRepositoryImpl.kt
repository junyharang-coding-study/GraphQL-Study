package com.junyharangstudy.kotlingraphqltest.api.people.repository

import com.junyharangstudy.kotlingraphqltest.api.common.QueryDslSupportUtil.Companion.queryDslPagingProcessing
import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType
import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role
import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex
import com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.people.model.entity.People
import com.junyharangstudy.kotlingraphqltest.api.people.model.entity.QPeople.people
import com.junyharangstudy.kotlingraphqltest.api.supply.model.entity.QSupply
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import org.springframework.util.StringUtils

@Repository
class PeopleQueryDslRepositoryImpl (private val jpaQueryFactory: JPAQueryFactory): PeopleQueryDslRepository {
    override fun findBySearchAndPaging(
        pageRequestDto: PageRequestDto,
        peopleSearchRequestDto: PeopleSearchRequestDto?
    ): List<People> {
        val peopleJPAQuery = jpaQueryFactory.selectFrom(people)
            .where(
                eqLastName(peopleSearchRequestDto?.lastName),
                eqFirstName(peopleSearchRequestDto?.firstName),
                eqSex(peopleSearchRequestDto?.sex),
                eqBloodType(peopleSearchRequestDto?.bloodType),
                eqServeYears(peopleSearchRequestDto?.serveYears),
                eqRole(peopleSearchRequestDto?.role),
                eqHometown(peopleSearchRequestDto?.hometown))

        if (pageRequestDto.getOrderBy()) {
            peopleJPAQuery.orderBy(people.peopleId.desc())
        }

        return queryDslPagingProcessing(peopleJPAQuery, pageRequestDto)
    }

    override fun findByTeamIdAndPaging(pageRequestDto: PageRequestDto, teamId: Long?): List<People> {
        val byteamIdPeopleJPAQuery = jpaQueryFactory.selectFrom(people)
            .where(eqTeamId(teamId))

        if (pageRequestDto.getOrderBy()) {
            byteamIdPeopleJPAQuery.orderBy(people.peopleId.desc())
        }

        return queryDslPagingProcessing(byteamIdPeopleJPAQuery, pageRequestDto)
    }

    private fun eqLastName(lastName: String?): BooleanExpression? {
        return if (!StringUtils.hasText(lastName)) {
            null
        } else {
            people.lastName.eq(lastName)
        }
    }

    private fun eqFirstName(firstName: String?): BooleanExpression? {
        return if (!StringUtils.hasText(firstName)) {
            null
        } else {
            people.firstName.eq(firstName)
        }
    }

    private fun eqSex(sex: Sex?): BooleanExpression? {
        return if (sex == null) {
            null
        } else {
            people.sex.eq(sex)
        }
    }

    private fun eqBloodType(bloodType: BloodType?): BooleanExpression? {
        return if (bloodType == null) {
            null
        } else {
            people.bloodType.eq(bloodType)
        }
    }

    private fun eqServeYears(serveYears: Int?): BooleanExpression? {
        return if (serveYears == null) {
            null
        } else {
            people.serveYears.eq(serveYears)
        }
    }

    private fun eqRole(role: Role?): BooleanExpression? {
        return if (role == null) {
            null
        } else {
            people.role.eq(role)
        }
    }

    private fun eqHometown(hometown: String?): BooleanExpression? {
        return if (!StringUtils.hasText(hometown)) {
            null
        } else {
            people.hometown.eq(hometown)
        }
    }

    private fun eqTeamId(teamId: Long?): BooleanExpression? {
        return if (teamId == null || teamId <= 0L) {
            null
        } else {
            people.team.teamId.eq(teamId)
        }
    }
}