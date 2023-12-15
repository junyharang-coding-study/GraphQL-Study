package com.junyharangstudy.kotlingraphqltest.api.common

import com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto
import com.querydsl.jpa.impl.JPAQuery
import org.springframework.stereotype.Component

@Component
class QueryDslSupportUtil {
    companion object {
        fun <T> queryDslPagingProcessing(jpaQuery: JPAQuery<T>, pageRequestDto: PageRequestDto): List<T> {
            var result: List<T> = emptyList()

            if (jpaQuery.stream().count() >= 2) {
                result = jpaQuery.offset(pageRequestDto.getOffset().toLong())
                    .limit(pageRequestDto.getLimit().toLong())
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