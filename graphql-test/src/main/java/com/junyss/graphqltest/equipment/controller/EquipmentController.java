package com.junyss.graphqltest.equipment.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.junyss.graphqltest.equipment.model.dto.EquipmentRequestDto;
import com.junyss.graphqltest.equipment.model.entity.Equipment;
import com.junyss.graphqltest.equipment.service.EquipmentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller // REST API가 아니기 때문에 @Controller 사용
public class EquipmentController {

	private final EquipmentService equipmentService;

	/**
	 * @MuationMapping은 REST API 구축 시 @PostMapping과 같은 어노테이션으로 graphql의 Mutaion에 사용.
	 * GraphQL은 Endpoint가 하나이기 때문에 @MutaionMapping만 지정하고, 다른 설정을 해 줄 필요가 없음.
	 */
	@MutationMapping
	// @Argument는 @RequestBody, @RequestParam과 같은 매개 변수 값을 지정할 때 사용.
	public Equipment save (@Argument EquipmentRequestDto equipmentRequestDto) {
		return equipmentService.save(equipmentRequestDto);
	}

	/**
	 * @QueryMapping도 Rest API 구축 시 @GetMapping과 같은 어노테이션이며, @SubscriptionMapping도 존재
	 */
	@QueryMapping
	public Page<Equipment> getEquipmentList (Pageable pageable) {
		return equipmentService.getEquipmentList(pageable);
	}

	@QueryMapping
	public Equipment getEquipment (@Argument String equipmentId) {
		return equipmentService.getEquipment(equipmentId);
	}
}
