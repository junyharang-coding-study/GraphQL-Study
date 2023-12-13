package com.junyharangstudy.kotlingraphqltest.common.constant

class PageRequestDto(
    var pageNumber: Long? = null,
    var perPageSize: Long? = null,
    var orderBy: Boolean? = null
) {

    fun getOffset(): Long {
        return((pageNumber?.minus(1) ?: 0) * (perPageSize ?: 0))
    }

    fun getLimit(): Long {
        return perPageSize ?: 0
    }
}