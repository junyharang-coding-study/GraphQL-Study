package com.junyss.graphqltest.equipment.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.junyss.graphqltest.common.util.PagingProcessUtil;
import com.junyss.graphqltest.equipment.model.dto.request.EquipmentRequestDto;
import com.junyss.graphqltest.equipment.model.dto.request.EquipmentSearchRequestDto;
import com.junyss.graphqltest.equipment.model.dto.response.EquipmentResponseDto;
import com.junyss.graphqltest.equipment.model.entity.Equipment;
import com.junyss.graphqltest.equipment.repository.EquipmentRepository;
import com.junyss.graphqltest.equipment.repository.querydsl.EquipmentQueryDslRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EquipmentServiceImpl implements EquipmentService {

	private final EquipmentRepository equipmentRepository;
	private final EquipmentQueryDslRepository equipmentQueryDslRepository;

	@Override
	public Equipment save(EquipmentRequestDto equipmentRequestDto) {
		return equipmentRepository.save(Equipment.toEntity(equipmentRequestDto));
	}

	@Override
	public List<EquipmentResponseDto> getEquipmentList(String equipmentId, String usedBy, String newOrUsed, Integer page, Integer size) {
		return equipmentQueryDslRepository.findBySearchAndPaging(
			new EquipmentSearchRequestDto(
					equipmentId,
					usedBy,
					newOrUsed),
					PagingProcessUtil.processPaging(page, size))
			.stream()
			.filter(Objects::nonNull)
			.map(equipment -> EquipmentResponseDto.builder()
				.equipmentId(equipment.getEquipmentId())
				.usedBy(equipment.getUsedBy())
				.count(equipment.getCount())
				.newOrUsed(equipment.getNewOrUsed())
				.build())
			.collect(Collectors.toList());
	}

	@Override
	public EquipmentResponseDto getEquipment(String equipmentId) {
		Optional<Equipment> findBySearchId = equipmentRepository.findAllByStringId(equipmentId);

		if (findBySearchId.isPresent()) {
			Equipment equipment = findBySearchId.get();

			return EquipmentResponseDto.builder()
				.equipmentId(equipment.getEquipmentId())
				.usedBy(equipment.getUsedBy())
				.count(equipment.getCount())
				.newOrUsed(equipment.getNewOrUsed())
				.build();
		}

		return null;
	}
}
