package com.junyharangstudy.kotlingraphqltest.api.equipment.repository

import com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentSearchRequestDto
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment
import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.QEquipment.equipment
import com.junyharangstudy.kotlingraphqltest.common.constant.Pagination.Companion.queryDslPagingProcessing
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQuery
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import org.springframework.util.StringUtils

@Repository
class EquipmentQueryDslRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : EquipmentQueryDslRepository {

    override fun findBySearchAndPaging(
        pageable: Pageable,
        equipmentSearchRequestDto: EquipmentSearchRequestDto?
    ): Page<Equipment> {
        val equipmentJPAQuery = jpaQueryFactory.selectFrom(equipment)
            .where(
                eqUsedBy(equipmentSearchRequestDto?.usedBy),
                eqNewOrUsed(equipmentSearchRequestDto?.newOrUsed),
            );

        if (pageable.sort.isSorted) {
            equipmentJPAQuery.orderBy(equipment.equipmentId.desc())
        }

        return PageImpl(
            queryDslPagingProcessing(equipmentJPAQuery, pageable),
            pageable,
            equipmentJPAQuery.stream().count()
        )
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



