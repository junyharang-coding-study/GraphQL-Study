package com.junyss.graphqltest.api.supply.model.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SupplyRequestDto {
	@NotBlank private String supplyId;
	@NotNull @Min(1) private Long teamId;
}
