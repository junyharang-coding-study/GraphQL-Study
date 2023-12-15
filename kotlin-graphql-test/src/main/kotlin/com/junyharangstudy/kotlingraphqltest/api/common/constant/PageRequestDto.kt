package com.junyharangstudy.kotlingraphqltest.api.common.constant

class PageRequestDto(
    val currentPage: Int?,
    val perPageSize: Int?,
    var orderBy: Boolean? = null,
) {
    fun getOffset(): Int {
        return if (currentPage == null || perPageSize == null) {
            0
        } else {
            (currentPage - 1) * perPageSize
        }
    }

    fun getLimit(): Int {
        return if (perPageSize == null) {
            0
        } else {
            perPageSize
        }
    }

    fun getOrderBy(): Boolean {
        if (orderBy == null) {
            return false
        }

        if (orderBy == true) {
            return true
        } else if (orderBy == false) {
            return false
        }
        return false
    }
}