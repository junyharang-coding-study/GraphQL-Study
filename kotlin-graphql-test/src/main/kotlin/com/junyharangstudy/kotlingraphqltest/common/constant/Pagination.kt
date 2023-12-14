package com.junyharangstudy.kotlingraphqltest.common.constant

import com.querydsl.jpa.impl.JPAQuery
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import kotlin.math.ceil

class Pagination(
    private var totalPages: Int? = null,
    private var totalElements: Long? = null,
    private var page: Int? = null,
    private var currentElements: Int? = null
) {
    constructor(page: Page<*>) : this(
        totalElements = page.totalElements,
        page = page.number,
        currentElements = page.numberOfElements,

    ) {
        totalPages = calculateTotalPages(page.totalElements, page.numberOfElements)
    }

    private fun calculateTotalPages(totalElements: Long, numberOfElements: Int): Int {
        val tempTotalPage = ceil(totalElements.toDouble() / numberOfElements).toInt()

        return if (tempTotalPage >= 1) {
            tempTotalPage
        } else {
            1
        }
    }

//    init {
//        var tempTotalPage = 0
//
//        if (totalElements != null && currentElements != null) {
//            tempTotalPage = ceil(totalElements!!.toDouble() / currentElements!!).toInt()
//        }
//
//        totalPages = if (tempTotalPage >= 1) {
//            tempTotalPage
//        } else {
//            1
//        }
//    }

    companion object {
        fun processPaging(page: Int, perPageSize: Int): PageRequest? {
            return if (page <= 0 && perPageSize <= 0) {
                null
            } else {
                PageRequest.of(page, perPageSize)
            }
        }

        fun <T> queryDslPagingProcessing(jpaQuery: JPAQuery<T>, pageable: Pageable): List<T> {
            var result: List<T> = emptyList()

            if (jpaQuery.stream().count() >= 2) {
                result = jpaQuery.offset(pageable.offset)
                    .limit(pageable.pageSize.toLong())
                    .fetch()
            } else {
                jpaQuery.fetchFirst()?.let {
                    result = listOf(it)
                }
            }

            return result
        }
    }
}

