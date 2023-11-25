package com.junyss.graphqltest.api.equipment.model.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EquipmentRequestDto {
	@NotBlank private String equipmentId;
	@NotBlank private String usedBy;
	@NotNull @Min(1) private Integer count;
	@NotBlank private String newOrUsed;
}
