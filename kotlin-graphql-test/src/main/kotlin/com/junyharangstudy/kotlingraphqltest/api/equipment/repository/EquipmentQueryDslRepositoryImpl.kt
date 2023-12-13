package com.junyharangstudy.kotlingraphqltest.api.equipment.repository

import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentResponseDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.QEquipment.equipment
import com.junyharangstudy.kotlingraphqltest.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.common.constant.queryDslPagingProcessing
import com.querydsl.core.types.ExpressionUtils.orderBy
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Repository
import org.springframework.util.StringUtils

@Repository
class EquipmentQueryDslRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
): EquipmentQueryDslRepository {

    override fun findBySearchAndPaging(
        pageRequestDto: PageRequestDto,
        equipmentSearchRequestDto: EquipmentSearchRequestDto
    ): Page<Equipment> {
        val equipmentJPAQuery = jpaQueryFactory.selectFrom(equipment)
            .where(
                eqUsedBy(equipmentSearchRequestDto.usedBy),
                eqNewOrUsed(equipmentSearchRequestDto.newOrUsed),
            ).offset(pageRequestDto.getOffset()).limit(pageRequestDto.getLimit());

        if (pageRequestDto.orderBy != null && pageRequestDto.orderBy == true) {
            equipmentJPAQuery.orderBy(equipment.equipmentId.desc())
        } else if (pageRequestDto.orderBy != null && pageRequestDto.orderBy == false) {
            equipmentJPAQuery.orderBy(equipment.equipmentId.asc())
        }

        return PageImpl(queryDslPagingProcessing(equipmentJPAQuery, pageRequestDto), pageRequestDto, equipmentJPAQuery.stream().count())
    }



    fun eqUsedBy(usedBy: String?): BooleanExpression? {
        return if (!StringUtils.hasText(usedBy)) {
            null
        } else {
            equipment.usedBy.eq(usedBy)
        }
    }

    fun eqNewOrUsed(newOrUsed: String?): BooleanExpression? {
        return if (!StringUtils.hasText(newOrUsed)) {
            null
        } else {
            equipment.newOrUsed.eq(newOrUsed)
        }
    }
}