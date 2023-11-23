package com.junyss.graphqltest.common.constant;

import org.springframework.data.domain.Pageable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DefaultListResponse<T> {
	private Integer statusCode;
	private String message;
	private Pagination pagination;
	private T data;

	/**
	 * <b>상태 코드 + 부가 설명 반환</b>
	 *
	 * @param statusCode Http Status Code Number
	 * @param message Response Body에 응답할 Message
	 * @return <T> DefaultResponse<T> Response Body 응답값
	 */

	public static <T> DefaultListResponse<T> response(
		final Integer statusCode,
		final String message) {
		return (DefaultListResponse<T>)DefaultListResponse.builder()
			.statusCode(statusCode)
			.message(message)
			.build();
	}

	/**
	 * <b>상태 코드 + 부가 설명 + Paging 정보 + 응답 데이터 반환</b>
	 *
	 * @param statusCode Http Status Code Number
	 * @param message Response Body에 응답할 Message
	 * @param data 연산 뒤 처리 결과값 객체
	 * @return <T> DefaultResponse<T> Response Body 응답값
	 */

	public static <T> DefaultListResponse<T> response(
		final Integer statusCode,
		final String message,
		final T data,
		final Pagination pagination) {
		return (DefaultListResponse<T>)DefaultListResponse.builder()
			.statusCode(statusCode)
			.message(message)
			.data(data)
			.pagination(pagination)
			.build();
	}
}
