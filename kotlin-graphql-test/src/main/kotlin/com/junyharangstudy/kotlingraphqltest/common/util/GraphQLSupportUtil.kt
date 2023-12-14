package com.junyharangstudy.kotlingraphqltest.common.util

import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
class GraphQLSupportUtil {
    companion object {
        fun <T> pageToList(pageTypeDto: Page<T>): List<T> {
            if (pageTypeDto.totalElements == 0L && !pageTypeDto.hasContent()) {
                return emptyList()
            }

            return pageTypeDto.content
        }
    }
}