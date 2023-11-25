package com.junyss.graphqltest.supply.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplyResponseDto {
	private String supplyId;
	private Long teamId;
}
