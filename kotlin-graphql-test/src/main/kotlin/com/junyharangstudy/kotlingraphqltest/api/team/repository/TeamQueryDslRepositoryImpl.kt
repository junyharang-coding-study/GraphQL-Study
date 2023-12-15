package com.junyharangstudy.kotlingraphqltest.api.team.repository

import com.junyharangstudy.kotlingraphqltest.api.common.QueryDslSupportUtil.Companion.queryDslPagingProcessing
import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.team.model.entity.QTeam.team
import com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import org.springframework.util.StringUtils

@Repository
class TeamQueryDslRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
): TeamQueryDslRepository {
    override fun findBySearchAndPaging(
        pageRequestDto: PageRequestDto,
        teamSearchRequestDto: TeamSearchRequestDto?
    ): List<Team> {
        val teamJPAQuery = jpaQueryFactory.selectFrom(team)
            .where(
                eqManager(teamSearchRequestDto?.manager),
                eqOffice(teamSearchRequestDto?.office),
                eqExtensionNumber(teamSearchRequestDto?.extensionNumber),
                eqMascot(teamSearchRequestDto?.mascot),
                eqCleaningDuty(teamSearchRequestDto?.cleaningDuty),
                eqProject(teamSearchRequestDto?.project),
            );

        if (pageRequestDto.getOrderBy()) {
            teamJPAQuery.orderBy(team.teamId.desc())
        }

        return queryDslPagingProcessing(teamJPAQuery, pageRequestDto)
    }

    fun eqManager(manager: String?): BooleanExpression? {
        return if (!StringUtils.hasText(manager)) {
            null
        } else {
            team.manager.eq(manager)
        }
    }

    fun eqOffice(office: String?): BooleanExpression? {
        return if (!StringUtils.hasText(office)) {
            null
        } else {
            team.office.eq(office)
        }
    }


    fun eqExtensionNumber(extensionNumber: String?): BooleanExpression? {
        return if (!StringUtils.hasText(extensionNumber)) {
            null
        } else {
            team.extensionNumber.eq(extensionNumber)
        }
    }

    fun eqMascot(mascot: String?): BooleanExpression? {
        return if (!StringUtils.hasText(mascot)) {
            null
        } else {
            team.mascot.eq(mascot)
        }
    }

    fun eqCleaningDuty(cleaningDuty: String?): BooleanExpression? {
        return if (!StringUtils.hasText(cleaningDuty)) {
            null
        } else {
            team.cleaningDuty.eq(cleaningDuty)
        }
    }

    fun eqProject(project: String?): BooleanExpression? {
        return if (!StringUtils.hasText(project)) {
            null
        } else {
            team.project.eq(project)
        }
    }
}