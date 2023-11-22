package com.junyss.graphqltest.equipment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.junyss.graphqltest.equipment.model.dto.EquipmentRequestDto;
import com.junyss.graphqltest.equipment.model.entity.Equipment;
import com.junyss.graphqltest.equipment.repository.EquipmentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EquipmentServiceImpl implements EquipmentService {

	private final EquipmentRepository equipmentRepository;

	@Override
	public Equipment save(EquipmentRequestDto equipmentRequestDto) {
		return equipmentRepository.save(Equipment.toEntity(equipmentRequestDto));
	}

	@Override
	public Page<Equipment> getEquipmentList(Pageable pageable) {
		return equipmentRepository.findAll(pageable);
	}

	@Override
	public Equipment getEquipment(String equipmentId) {
		return equipmentRepository.findAllByStringId(equipmentId);
	}
}
