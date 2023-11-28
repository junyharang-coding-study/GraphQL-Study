package com.junyss.graphqltest.api.equipment.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junyss.graphqltest.api.equipment.model.dto.request.EquipmentRequestDto;
import com.junyss.graphqltest.api.equipment.model.dto.request.EquipmentSearchRequestDto;
import com.junyss.graphqltest.api.equipment.model.dto.response.EquipmentResponseDto;
import com.junyss.graphqltest.api.equipment.model.dto.response.EquipmentsAdvResponseDto;
import com.junyss.graphqltest.api.equipment.model.entity.Equipment;
import com.junyss.graphqltest.api.equipment.repository.EquipmentRepository;
import com.junyss.graphqltest.api.equipment.repository.querydsl.EquipmentQueryDslRepository;
import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.common.constant.Pagination;
import com.junyss.graphqltest.common.util.GraphQLSupportUtil;
import com.junyss.graphqltest.common.util.ObjectUtil;
import com.junyss.graphqltest.common.util.PagingProcessUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EquipmentServiceImpl implements EquipmentService {

	private final EquipmentRepository equipmentRepository;
	private final EquipmentQueryDslRepository equipmentQueryDslRepository;

	@Transactional
	@Override
	public DefaultResponse<String> saveForEquipment(EquipmentRequestDto equipmentRequestDto) {

		if (equipmentRequestDto == null) {
			return DefaultResponse.response(HttpStatus.NO_CONTENT.value(), "Failed Create");
		}

		return DefaultResponse.response(
			HttpStatus.CREATED.value(),
			"Success Create",
			equipmentRepository.save(
					Equipment.toEntity(equipmentRequestDto))
				.getEquipmentId());
	}

	@Transactional(readOnly = true)
	@Override
	public DefaultResponse<List<EquipmentResponseDto>> getEquipmentList(
		String equipmentId,
		String usedBy,
		String newOrUsed,
		Integer page,
		Integer size) {

		Page<EquipmentResponseDto> result = equipmentQueryDslRepository.findBySearchAndPaging(
			new EquipmentSearchRequestDto(
				equipmentId,
				usedBy,
				newOrUsed),
			PagingProcessUtil.processPaging(page, size));

		if (ObjectUtil.checkObjectExistence(result)) {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}

		List<EquipmentResponseDto> equipmentResponseDtoList = GraphQLSupportUtil.pageToList(result);

		if (!equipmentResponseDtoList.isEmpty()) {
			return DefaultResponse.response(
				HttpStatus.OK.value(),
				"OK",
				equipmentResponseDtoList,
				new Pagination(result));
		} else {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}
	}

	@Override
	public DefaultResponse<List<EquipmentsAdvResponseDto>> getEquipmentsAdv(
		@Argument String equipmentId,
		@Argument String usedBy,
		@Argument String newOrUsed,
		@Argument Integer page,
		@Argument Integer size) {

		Page<EquipmentResponseDto> result = equipmentQueryDslRepository.findBySearchAndPaging(
			new EquipmentSearchRequestDto(
				equipmentId,
				usedBy,
				newOrUsed),
			PagingProcessUtil.processPaging(page, size));

		if (ObjectUtil.checkObjectExistence(result)) {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}

		List<EquipmentsAdvResponseDto> equipmentsAdvResponseDtoList = GraphQLSupportUtil.pageToList(result)
			.stream()
			.filter(Objects::nonNull)
			.map(equipmentResponseDto -> {
				EquipmentsAdvResponseDto equipmentsAdvResponseDto = new EquipmentsAdvResponseDto();
				equipmentsAdvResponseDto.setEquipmentId(equipmentResponseDto.getEquipmentId());
				equipmentsAdvResponseDto.setUsedBy(equipmentResponseDto.getUsedBy());
				equipmentsAdvResponseDto.setCount(equipmentResponseDto.getCount());
				equipmentsAdvResponseDto.setNewOrUsed(equipmentResponseDto.getNewOrUsed());

				if (equipmentResponseDto.getUsedBy().equals("developer")) {
					equipmentsAdvResponseDto.setUseRate(
						Float.parseFloat(
							String.format(
								"%.2f",
								new Random()
									.nextDouble())));
				}
				equipmentsAdvResponseDto.setIsNew(equipmentResponseDto.getNewOrUsed().equals("new"));

				return equipmentsAdvResponseDto;

			})
			.collect(Collectors.toList());

		if (equipmentsAdvResponseDtoList.isEmpty()) {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}

		return DefaultResponse.response(
			HttpStatus.OK.value(),
			"OK",
			equipmentsAdvResponseDtoList,
			new Pagination(result));
	}

	@Transactional(readOnly = true)
	@Override
	public DefaultResponse<EquipmentResponseDto> getEquipment(String equipmentId) {
		Optional<Equipment> findByEquipmentId = equipmentRepository.findByEquipmentId(equipmentId);

		if (findByEquipmentId.isPresent()) {
			Equipment equipment = findByEquipmentId.get();

			return DefaultResponse.response(
				HttpStatus.OK.value(),
				"OK",
				EquipmentResponseDto.builder()
					.equipmentId(equipment.getEquipmentId())
					.usedBy(equipment.getUsedBy())
					.count(equipment.getCount())
					.newOrUsed(equipment.getNewOrUsed())
					.build());
		}

		return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
	}

	@Transactional
	@Override
	public DefaultResponse<String> updateEquipment(EquipmentRequestDto equipmentRequestDto) {

		Optional<Equipment> equipmentRepositoryById = equipmentRepository.findById(
			equipmentRequestDto.getEquipmentId());

		Equipment equipment = checkUpdateRequest(equipmentRequestDto, equipmentRepositoryById);

		if (equipment == null) {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET");
		}

		return DefaultResponse.response(
			HttpStatus.OK.value(),
			"Success Update",
			equipmentRepository.save(equipment).getEquipmentId());
	}

	@Transactional
	@Override
	public DefaultResponse<String> deleteEquipment(String equipmentId) {
		Optional<Equipment> equipmentRepositoryById = equipmentRepository.findById(equipmentId);

		if (equipmentRepositoryById.isPresent()) {
			equipmentRepository.deleteById(equipmentId);

			return DefaultResponse.response(HttpStatus.OK.value(), "Deleted Success", equipmentId);
		}

		return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DELETE TARGET", equipmentId);
	}

	private Equipment checkUpdateRequest(EquipmentRequestDto equipmentRequestDto,
		Optional<Equipment> equipmentRepositoryById) {
		if (equipmentRepositoryById.isEmpty()) {
			return null;
		} else {
			Equipment equipment = equipmentRepositoryById.get();

			if (equipmentRequestDto.getUsedBy() != null) {
				equipment.updateUsedBy(equipmentRequestDto.getUsedBy());
			}

			if (equipmentRequestDto.getCount() != null) {
				equipment.updateCount(equipmentRequestDto.getCount());
			}

			if (equipmentRequestDto.getNewOrUsed() != null) {
				equipment.updateNewOrUsed(equipmentRequestDto.getNewOrUsed());
			}
			return equipment;
		}
	}
}
