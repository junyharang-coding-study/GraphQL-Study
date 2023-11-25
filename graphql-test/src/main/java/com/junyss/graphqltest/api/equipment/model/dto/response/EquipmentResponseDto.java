package com.junyss.graphqltest.api.equipment.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentResponseDto {
	private String equipmentId;
	private String usedBy;
	private Integer count;
	private String newOrUsed;
}
