package com.junyharangstudy.kotlingraphqltest.api.equipment.repository

import com.junyharangstudy.kotlingraphqltest.api.common.QueryDslSupportUtil.Companion.queryDslPagingProcessing
import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.QEquipment.equipment
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import org.springframework.util.StringUtils

@Repository
class EquipmentQueryDslRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : EquipmentQueryDslRepository {

    override fun findBySearchAndPaging(
        pageRequestDto: PageRequestDto,
        equipmentSearchRequestDto: EquipmentSearchRequestDto?
    ): List<Equipment> {
        val equipmentJPAQuery = jpaQueryFactory.selectFrom(equipment)
            .where(
                eqUsedBy(equipmentSearchRequestDto?.usedBy),
                eqNewOrUsed(equipmentSearchRequestDto?.newOrUsed),
            );

        if (pageRequestDto.getOrderBy()) {
            equipmentJPAQuery.orderBy(equipment.equipmentId.desc())
        }

        return queryDslPagingProcessing(equipmentJPAQuery, pageRequestDto)
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



