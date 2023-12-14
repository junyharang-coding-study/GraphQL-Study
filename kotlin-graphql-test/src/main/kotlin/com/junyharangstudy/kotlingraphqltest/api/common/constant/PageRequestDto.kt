package com.junyharangstudy.kotlingraphqltest.api.common.constant

class PageRequestDto(
    val currentPage: Int?,
    val perPageSize: Int?,
    var orderBy: Boolean? = null
) {
//
//    fun getOffset(): Long {
//        return((pageNumber?.minus(1) ?: 0) * (perPageSize ?: 0))
//    }
//
//    fun getLimit(): Long {
//        return perPageSize ?: 0
//    }
}