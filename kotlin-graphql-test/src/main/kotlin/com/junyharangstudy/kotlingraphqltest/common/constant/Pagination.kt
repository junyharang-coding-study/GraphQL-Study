package com.junyharangstudy.kotlingraphqltest.common.constant

import kotlin.math.ceil

class Pagination(
    perPageSize: Int,
    totalElementCount: Int,
) {

    var perPageSize: Int = perPageSize
        private set
    var totalElementCount: Int = totalElementCount
        private set

    private var totalPage: Int = 0

    init {
        val tempTotalPage = ceil(totalElementCount.toDouble() / perPageSize).toInt()

        totalPage = if (tempTotalPage >= 1) {
            tempTotalPage
        } else {
            1
        }
    }
}

