package com.junyss.graphqltest.equipment.model.dto;

import lombok.Data;

@Data
public class EquipmentSearchRequestDto {

	private String id;
	private String usedBy;
	private String newOrUsed;
}
