package com.junyss.graphqltest.equipment.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentSearchRequestDto {
	private String equipmentId;
	private String usedBy;
	private String newOrUsed;
}
