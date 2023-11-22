package com.junyss.graphqltest.equipment.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.junyss.graphqltest.equipment.model.dto.EquipmentRequestDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
			equipmentRequestDto.getId(),
			equipmentRequestDto.getUsedBy(),
			equipmentRequestDto.getCount(),
		equipmentRequestDto.getNewOrUsed());
	}
}
