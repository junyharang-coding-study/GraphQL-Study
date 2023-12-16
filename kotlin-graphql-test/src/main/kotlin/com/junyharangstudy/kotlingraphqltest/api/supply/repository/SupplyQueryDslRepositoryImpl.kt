package com.junyharangstudy.kotlingraphqltest.api.supply.repository

import com.junyharangstudy.kotlingraphqltest.api.common.QueryDslSupportUtil.Companion.queryDslPagingProcessing
import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.supply.model.entity.QSupply.supply
import com.junyharangstudy.kotlingraphqltest.api.supply.model.entity.Supply
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class SupplyQueryDslRepositoryImpl (private val jpaQueryFactory: JPAQueryFactory): SupplyQueryDslRepository {
    override fun findBySearchAndPaging(pageRequestDto: PageRequestDto, teamId: Long?): List<Supply> {
        val supplyJPAQuery = jpaQueryFactory.selectFrom(supply)
            .where(eqTeamId(teamId))

        if (pageRequestDto.getOrderBy()) {
            supplyJPAQuery.orderBy(supply.supplyId.desc())
        }

        return queryDslPagingProcessing(supplyJPAQuery, pageRequestDto)
    }

    private fun eqTeamId(teamId: Long?): BooleanExpression? {
        return if (teamId == null || teamId <= 0L) {
            null
        } else {
            supply.team.teamId.eq(teamId)
        }
    }
}