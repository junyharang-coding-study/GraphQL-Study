package com.junyss.graphqltest.api.equipment.service;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;

import com.junyss.graphqltest.api.equipment.model.dto.response.EquipmentsAdvResponseDto;
import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.api.equipment.model.dto.request.EquipmentRequestDto;
import com.junyss.graphqltest.api.equipment.model.dto.response.EquipmentResponseDto;

public interface EquipmentService {

	DefaultResponse<String> saveForEquipment(EquipmentRequestDto equipmentRequestDto);

	DefaultResponse<List<EquipmentResponseDto>> getEquipmentList(
		String equipmentId,
		String usedBy,
		String newOrUsed,
		Integer page,
		Integer size);

	DefaultResponse<List<EquipmentsAdvResponseDto>> getEquipmentsAdv(
		@Argument String equipmentId,
		@Argument String usedBy,
		@Argument String newOrUsed,
		@Argument Integer page,
		@Argument Integer size);

	DefaultResponse<EquipmentResponseDto> getEquipment(String equipmentId);

	DefaultResponse<String> updateEquipment(EquipmentRequestDto equipmentRequestDto);

	DefaultResponse<String> deleteEquipment(String equipmentId);


}
