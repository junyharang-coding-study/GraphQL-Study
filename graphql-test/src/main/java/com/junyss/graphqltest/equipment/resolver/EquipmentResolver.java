package com.junyss.graphqltest.equipment.resolver;

import java.util.List;

import org.springframework.data.domain.Page;

import com.junyss.graphqltest.common.constant.DefaultListResponse;
import com.junyss.graphqltest.equipment.model.dto.request.EquipmentRequestDto;
import com.junyss.graphqltest.equipment.model.dto.response.EquipmentResponseDto;
import com.junyss.graphqltest.equipment.model.entity.Equipment;

public interface EquipmentResolver {

	Equipment save(EquipmentRequestDto equipmentRequestDto);

	DefaultListResponse<List<EquipmentResponseDto>> getEquipmentList(String equipmentId, String usedBy, String newOrUsed, Integer page, Integer size);

	EquipmentResponseDto getEquipment(String equipmentId);
}
