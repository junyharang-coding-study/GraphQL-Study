package com.junyss.graphqltest.api.supply.service;

import java.util.List;

import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.api.supply.model.dto.request.SupplyRequestDto;
import com.junyss.graphqltest.api.supply.model.dto.response.SupplyResponseDto;

public interface SupplyService {
	DefaultResponse<String> saveForSupply(SupplyRequestDto supplyRequestDto);

	DefaultResponse<List<SupplyResponseDto>> getSupplyList(Integer page, Integer size);

	DefaultResponse<SupplyResponseDto> getSupplyBySupplyId(String supplyId);

	DefaultResponse<List<SupplyResponseDto>> getSupplyByTeamId(Long teamId, Integer page, Integer size);

	DefaultResponse<String> deleteSupply(String supplyId);
}
