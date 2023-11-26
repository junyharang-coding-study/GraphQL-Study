package com.junyss.graphqltest.api.equipment.model.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EquipmentsAdvResponseDto {
	private String equipmentId;
	private String usedBy;
	private Integer count;
	private String newOrUsed;
	private Float useRate;
	private Boolean isNew;

	@Builder
	public EquipmentsAdvResponseDto(
		String equipmentId,
		String usedBy,
		Integer count,
		String newOrUsed,
		Float useRate,
		Boolean isNew) {

		this.equipmentId = equipmentId;
		this.usedBy = usedBy;
		this.count = count;
		this.newOrUsed = newOrUsed;

		if (useRate == null) {
			this.useRate = 0F;
		} else {
			this.useRate = useRate;
		}

		if (isNew == null) {
			this.isNew = false;
		} else {
			this.isNew = isNew;
		}
	}
}
