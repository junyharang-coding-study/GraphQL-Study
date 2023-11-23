package com.junyss.graphqltest.equipment.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.junyss.graphqltest.common.constant.DefaultListResponse;
import com.junyss.graphqltest.equipment.model.dto.request.EquipmentRequestDto;
import com.junyss.graphqltest.equipment.model.dto.response.EquipmentResponseDto;
import com.junyss.graphqltest.equipment.model.entity.Equipment;

public interface EquipmentService {

	Equipment save(EquipmentRequestDto equipmentRequestDto);

	DefaultListResponse<Page<EquipmentResponseDto>> getEquipmentList(String equipmentId, String usedBy, String newOrUsed, Integer page, Integer size);

	EquipmentResponseDto getEquipment(String equipmentId);
}
