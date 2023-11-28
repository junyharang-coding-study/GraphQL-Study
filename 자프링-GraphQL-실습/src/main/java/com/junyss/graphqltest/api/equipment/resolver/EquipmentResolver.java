package com.junyss.graphqltest.api.equipment.resolver;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.junyss.graphqltest.api.equipment.model.dto.response.EquipmentsAdvResponseDto;
import com.junyss.graphqltest.api.equipment.service.EquipmentService;
import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.api.equipment.model.dto.request.EquipmentRequestDto;
import com.junyss.graphqltest.api.equipment.model.dto.response.EquipmentResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller // REST API가 아니기 때문에 @Controller 사용
public class EquipmentResolver {

	private final EquipmentService equipmentService;

	/**
	 * @MuationMapping은 REST API 구축 시 @PostMapping과 같은 어노테이션으로 graphql의 Mutaion에 사용.
	 * GraphQL은 Endpoint가 하나이기 때문에 @MutaionMapping만 지정하고, 다른 설정을 해 줄 필요가 없음.
	 */
	@MutationMapping
	// @Argument는 @RequestBody, @RequestParam과 같은 매개 변수 값을 지정할 때 사용.
	public DefaultResponse<String> saveForEquipment (@Argument("input") EquipmentRequestDto equipmentRequestDto) {
		return equipmentService.saveForEquipment(equipmentRequestDto);
	}

	/**
	 * @QueryMapping도 Rest API 구축 시 @GetMapping과 같은 어노테이션이며, @SubscriptionMapping도 존재
	 */
	@QueryMapping
	public DefaultResponse<List<EquipmentResponseDto>> getEquipmentList (
		@Argument String equipmentId,
		@Argument String usedBy,
		@Argument String newOrUsed,
		@Argument Integer page,
		@Argument Integer size) {
		return equipmentService.getEquipmentList(equipmentId, usedBy, newOrUsed, page, size);
	}

	@QueryMapping
	public DefaultResponse<List<EquipmentsAdvResponseDto>> getEquipmentsAdv (
		@Argument String equipmentId,
		@Argument String usedBy,
		@Argument String newOrUsed,
		@Argument Integer page,
		@Argument Integer size) {
		return equipmentService.getEquipmentsAdv(
			equipmentId,
			usedBy,
			newOrUsed,
			page,
			size);
	}

	@QueryMapping
	public DefaultResponse<EquipmentResponseDto> getEquipment (@Argument String equipmentId) {
		return equipmentService.getEquipment(equipmentId);
	}

	@MutationMapping
	public DefaultResponse<String> updateEquipment (@Argument("input") EquipmentRequestDto equipmentRequestDto) {
		return equipmentService.updateEquipment(equipmentRequestDto);
	}

	@MutationMapping
	public DefaultResponse<String> deleteEquipment (@Argument String equipmentId) {
		return equipmentService.deleteEquipment(equipmentId);
	}
}
