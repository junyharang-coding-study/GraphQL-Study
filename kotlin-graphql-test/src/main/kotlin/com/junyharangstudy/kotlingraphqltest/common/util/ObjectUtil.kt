package com.junyharangstudy.kotlingraphqltest.common.util

import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
class ObjectUtil {
    companion object {
        fun <T> checkObjectExistence(targetPageObject: Page<T>): Boolean {
            return targetPageObject.totalElements.toInt() == 0 && !targetPageObject.hasContent()
        }
    }
}