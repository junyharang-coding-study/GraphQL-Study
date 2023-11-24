package com.junyss.graphqltest.equipment.resolver;

import java.util.List;

import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.equipment.model.dto.request.EquipmentRequestDto;
import com.junyss.graphqltest.equipment.model.dto.response.EquipmentResponseDto;

public interface EquipmentResolver {

	DefaultResponse<String> saveForEquipment(EquipmentRequestDto equipmentRequestDto);

	DefaultResponse<List<EquipmentResponseDto>> getEquipmentList(String equipmentId, String usedBy, String newOrUsed, Integer page, Integer size);

	DefaultResponse<EquipmentResponseDto> getEquipment(String equipmentId);

	DefaultResponse<String> updateEquipment(EquipmentRequestDto equipmentRequestDto);

	DefaultResponse<String> deleteEquipment(String equipmentId);
}
