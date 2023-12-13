package com.junyharangstudy.kotlingraphqltest.common.constant

class DefaultResponse<T> (
    val statusCode: Int,
    val message: String,
    val pagination: Pagination?,
    val data: T?
) {
    companion object {
        /**
         * <b>상태 코드 + 부가 설명 반환</b>
         *
         * @param statusCode Http 상태 코드 번호
         * @param message 응답 본문에 포함될 메시지
         * @return <T> DefaultResponse<T> 응답 본문 값
         */
        fun <T> response(statusCode: Int, message: String): DefaultResponse<T> {
            return DefaultResponse(statusCode, message, null, null)
        }

        /**
         * <b>상태 코드 + 부가 설명 + 페이지 정보 + 응답 데이터 반환</b>
         *
         * @param statusCode Http 상태 코드 번호
         * @param message 응답 본문에 포함될 메시지
         * @param data 연산 후 처리 결과 객체
         * @return <T> DefaultResponse<T> 응답 본문 값
         */
        fun <T> response(statusCode: Int, message: String, data: T?): DefaultResponse<T> {
            return DefaultResponse(statusCode, message, null, data)
        }

        /**
         * <b>상태 코드 + 부가 설명 + 페이지 정보 + 응답 데이터 반환</b>
         *
         * @param statusCode Http 상태 코드 번호
         * @param message 응답 본문에 포함될 메시지
         * @param data 연산 후 처리 결과 객체
         * @param pagination 페이지 정보
         * @return <T> DefaultResponse<T> 응답 본문 값
         */
        fun <T> response(statusCode: Int, message: String, data: T?, pagination: Pagination?): DefaultResponse<T> {
            return DefaultResponse(statusCode, message, pagination, data)
        }
    }
}