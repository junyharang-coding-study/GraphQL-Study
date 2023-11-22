package com.junyss.graphqltest.equipment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.junyss.graphqltest.equipment.model.dto.EquipmentRequestDto;
import com.junyss.graphqltest.equipment.model.entity.Equipment;

public interface EquipmentService {

	Equipment save(EquipmentRequestDto equipmentRequestDto);

	Page<Equipment> getEquipmentList(Pageable pageable);

	Equipment getEquipment(String equipmentId);
}
