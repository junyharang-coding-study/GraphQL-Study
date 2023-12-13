package com.junyharangstudy.kotlingraphqltest.common.constant

import com.querydsl.jpa.impl.JPAQuery
import org.springframework.data.domain.PageRequest
import kotlin.math.ceil

class Pagination(
    perPageSize: Int,
    totalCount: Int
) {
    var perPageSize: Int = perPageSize
        private set

    var totalCount: Int = totalCount
        private set

    var totalPage: Int
        private set

    init {
        val tempTotalPage = ceil(totalCount.toDouble() / perPageSize).toInt()

        totalPage = if (tempTotalPage >= 1) {
            tempTotalPage
        } else {
            1
        }
    }
}

fun processPaging(page: Int, perPageSize: Int): PageRequest? {
    return if (page <= 0 && perPageSize <= 0) {
        null
    } else {
        PageRequest.of(page, perPageSize)
    }
}

fun <T> queryDslPagingProcessing(jpaQuery: JPAQuery<T>, pageRequestDto: PageRequestDto): List<T> {
    var result: List<T> = emptyList()

    if (jpaQuery.stream().count() >= 2) {
        result = jpaQuery.offset(pageRequestDto.getOffset())
            .limit(pageRequestDto.getLimit())
            .fetch()
    } else {
        jpaQuery.fetchFirst()?.let {
            result = listOf(it)
        }
    }

    return result
}