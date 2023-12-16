package com.junyharangstudy.kotlingraphqltest.api.software.repository

import com.junyharangstudy.kotlingraphqltest.api.common.QueryDslSupportUtil.Companion.queryDslPagingProcessing
import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.software.model.entity.QSoftware.software
import com.junyharangstudy.kotlingraphqltest.api.software.model.entity.Software
import com.junyharangstudy.kotlingraphqltest.common.constant.Pagination
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import org.springframework.util.StringUtils

@Repository
class SoftwareQueryDslRepositoryImpl (
    private val jpaQueryFactory: JPAQueryFactory
): SoftwareQueryDslRepository {

    override fun findBySearchAndPaging(
        pageRequestDto: PageRequestDto,
        softwareSearchRequestDto: SoftwareSearchRequestDto?
    ): List<Software> {
        val softwareJPAQuery = jpaQueryFactory.selectFrom(software)
            .where(
                eqUsedBy(softwareSearchRequestDto?.usedBy),
                eqDevelopedBy(softwareSearchRequestDto?.developedBy),
                eqDescription(softwareSearchRequestDto?.description)
            );

        if (pageRequestDto.getOrderBy()) {
            softwareJPAQuery.orderBy(software.softwareId.desc())
        }

        return queryDslPagingProcessing(softwareJPAQuery, pageRequestDto)
    }

    fun eqUsedBy(usedBy: String?): BooleanExpression? {
        return if (!StringUtils.hasText(usedBy)) {
            null
        } else {
            software.usedBy.eq(usedBy)
        }
    }

    fun eqDevelopedBy(developedBy: String?): BooleanExpression? {
        return if (!StringUtils.hasText(developedBy)) {
            null
        } else {
            software.developedBy.eq(developedBy)
        }
    }

    fun eqDescription(description: String?): BooleanExpression? {
        return if (!StringUtils.hasText(description)) {
            null
        } else {
            software.description.eq(description)
        }
    }
}