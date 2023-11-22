package com.junyss.graphqltest.equipment.model.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EquipmentRequestDto {
	@NotBlank private String id;
	@NotBlank private String usedBy;
	@NotBlank private Integer count;
	@NotBlank private String newOrUsed;
}
