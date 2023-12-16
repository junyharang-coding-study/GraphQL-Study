package com.junyharangstudy.kotlingraphqltest.api.role.repository

import com.junyharangstudy.kotlingraphqltest.api.common.QueryDslSupportUtil.Companion.queryDslPagingProcessing
import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.role.model.entity.QRole.role
import com.junyharangstudy.kotlingraphqltest.api.role.model.entity.Role
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import org.springframework.util.StringUtils

@Repository
class RoleQueryDslRepositoryImpl (private val jpaQueryFactory: JPAQueryFactory): RoleQueryDslRepository {
    override fun findBySearchAndPaging(
        pageRequestDto: PageRequestDto,
        roleSearchRequestDto: RoleSearchRequestDto?
    ): List<Role> {
        val roleJPAQuery = jpaQueryFactory.selectFrom(role)
            .where(
                eqJob(roleSearchRequestDto?.job),
                eqRequirement(roleSearchRequestDto?.requirement)
            )

        if (pageRequestDto.getOrderBy()) {
            roleJPAQuery.orderBy(role.roleId.desc())
        }

        return queryDslPagingProcessing(roleJPAQuery, pageRequestDto)
    }

    private fun eqJob(job: String?): BooleanExpression? {
        return if (!StringUtils.hasText(job)) {
            null
        } else {
            role.job.eq(job)
        }
    }

    private fun eqRequirement(requirement: String?): BooleanExpression? {
        return if (!StringUtils.hasText(requirement)) {
            null
        } else {
            role.requirement.eq(requirement)
        }
    }
}