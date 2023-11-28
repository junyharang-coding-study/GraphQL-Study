package com.junyss.graphqltest.api.supply.resolver;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.junyss.graphqltest.api.supply.model.dto.request.SupplyRequestDto;
import com.junyss.graphqltest.api.supply.model.dto.response.SupplyResponseDto;
import com.junyss.graphqltest.api.supply.service.SupplyService;
import com.junyss.graphqltest.common.constant.DefaultResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SupplyResolver {

	private final SupplyService supplyService;

	@MutationMapping
	public DefaultResponse<String> saveForSupply (@Argument("input") SupplyRequestDto supplyRequestDto) {
		return supplyService.saveForSupply(supplyRequestDto);
	}

	@QueryMapping
	public DefaultResponse<List<SupplyResponseDto>> getSupplyList (
		@Argument Integer page,
		@Argument Integer size) {

		return supplyService.getSupplyList(page, size);
	}

	@QueryMapping
	public DefaultResponse<SupplyResponseDto> getSupplyBySupplyId (@Argument String supplyId) {
		return supplyService.getSupplyBySupplyId(supplyId);
	}

	@QueryMapping
	public DefaultResponse<List<SupplyResponseDto>> getSupplyByTeamId (
		@Argument Long teamId,
		@Argument Integer page,
		@Argument Integer size) {

		return supplyService.getSupplyByTeamId(teamId, page, size);
	}

	@MutationMapping
	public DefaultResponse<String> deleteSupply (@Argument String supplyId) {
		return supplyService.deleteSupply(supplyId);
	}
}