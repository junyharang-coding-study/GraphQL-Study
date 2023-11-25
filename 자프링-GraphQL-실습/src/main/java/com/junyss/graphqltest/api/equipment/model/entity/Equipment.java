package com.junyss.graphqltest.api.equipment.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.junyss.graphqltest.api.equipment.model.dto.request.EquipmentRequestDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Equipment {

	@Id
	private String equipmentId;
	private String usedBy;
	private Integer count;
	private String newOrUsed;

	public static Equipment toEntity (EquipmentRequestDto equipmentRequestDto) {
		return new Equipment(
			equipmentRequestDto.getEquipmentId(),
			equipmentRequestDto.getUsedBy(),
			equipmentRequestDto.getCount(),
		equipmentRequestDto.getNewOrUsed());
	}

	public void updateUsedBy(String usedBy) {
		this.usedBy = usedBy;
	}

	public void updateCount(Integer count) {
		this.count = count;
	}

	public void updateNewOrUsed(String newOrUsed) {
		this.newOrUsed = newOrUsed;
	}
}
