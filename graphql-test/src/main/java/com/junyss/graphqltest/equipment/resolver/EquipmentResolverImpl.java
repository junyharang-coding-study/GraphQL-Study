package com.junyss.graphqltest.equipment.resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.junyss.graphqltest.common.constant.DefaultListResponse;
import com.junyss.graphqltest.common.constant.Pagination;
import com.junyss.graphqltest.common.util.GraphQLSupportUtil;
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
public class EquipmentResolverImpl implements EquipmentResolver {

	private final EquipmentRepository equipmentRepository;
	private final EquipmentQueryDslRepository equipmentQueryDslRepository;

	@Override
	public Equipment save(EquipmentRequestDto equipmentRequestDto) {
		return equipmentRepository.save(Equipment.toEntity(equipmentRequestDto));
	}

	@Override
	public DefaultListResponse<List<EquipmentResponseDto>> getEquipmentList(String equipmentId, String usedBy, String newOrUsed, Integer page, Integer size) {

		Page<EquipmentResponseDto> result = equipmentQueryDslRepository.findBySearchAndPaging(
				new EquipmentSearchRequestDto(
					equipmentId,
					usedBy,
					newOrUsed),
				PagingProcessUtil.processPaging(page, size));

		if (result.getTotalElements() == 0 && !result.hasContent()) {
			return DefaultListResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}

		List<EquipmentResponseDto> equipmentResponseDtoList = GraphQLSupportUtil.pageToList(result);

		if (!equipmentResponseDtoList.isEmpty()) {
			return DefaultListResponse.response(HttpStatus.OK.value(), "OK", equipmentResponseDtoList, new Pagination(result));
		} else {
			return DefaultListResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}

		// List<EquipmentResponseDto> result = equipmentQueryDslRepository.findBySearchAndPaging(
		// 		new EquipmentSearchRequestDto(
		// 			equipmentId,
		// 			usedBy,
		// 			newOrUsed),
		// 		PagingProcessUtil.processPaging(page, size))
		// 	.stream()
		// 	.filter(Objects::nonNull)
		// 	.map(equipment -> EquipmentResponseDto.builder()
		// 		.equipmentId(equipment.getEquipmentId())
		// 		.usedBy(equipment.getUsedBy())
		// 		.count(equipment.getCount())
		// 		.newOrUsed(equipment.getNewOrUsed())
		// 		.build())
		// 	.collect(Collectors.toList());


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
