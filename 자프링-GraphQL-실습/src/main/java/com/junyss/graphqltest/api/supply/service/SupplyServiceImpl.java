package com.junyss.graphqltest.api.supply.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.junyss.graphqltest.api.supply.model.dto.request.SupplyRequestDto;
import com.junyss.graphqltest.api.supply.model.dto.response.SupplyResponseDto;
import com.junyss.graphqltest.api.supply.repository.SupplyQueryDslRepository;
import com.junyss.graphqltest.api.supply.repository.SupplyRepository;
import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.common.constant.Pagination;
import com.junyss.graphqltest.common.util.GraphQLSupportUtil;
import com.junyss.graphqltest.common.util.ObjectUtil;
import com.junyss.graphqltest.common.util.PagingProcessUtil;
import com.junyss.graphqltest.api.supply.model.entity.Supply;
import com.junyss.graphqltest.api.team.model.entity.Team;
import com.junyss.graphqltest.api.team.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SupplyServiceImpl implements SupplyService {

	private final SupplyRepository supplyRepository;
	private final SupplyQueryDslRepository supplyQueryDslRepository;
	private final TeamRepository teamRepository;

	@Override
	public DefaultResponse<String> saveForSupply(SupplyRequestDto supplyRequestDto) {
		if (supplyRequestDto == null) {
			return DefaultResponse.response(HttpStatus.NO_CONTENT.value(), "Failed Create");
		}

		Optional<Team> team = teamRepository.findById(supplyRequestDto.getTeamId());

		if (team.isPresent()) {
			return DefaultResponse.response(
				HttpStatus.CREATED.value(),
				"Success Create",
				supplyRepository.save(
						Supply.toEntity(
							supplyRequestDto.getSupplyId(),
							team.get()))
					.getSupplyId());
		}
		return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "Failed Create");
	}

	@Override
	public DefaultResponse<List<SupplyResponseDto>> getSupplyList(Integer page, Integer size) {
		Page<SupplyResponseDto> result = supplyQueryDslRepository.findByPaging(
			PagingProcessUtil.processPaging(page, size));

		if (ObjectUtil.checkObjectExistence(result)) {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}

		List<SupplyResponseDto> supplyResponseDtoList = GraphQLSupportUtil.pageToList(result);

		if (!supplyResponseDtoList.isEmpty()) {
			return DefaultResponse.response(
				HttpStatus.OK.value(),
				"OK",
				supplyResponseDtoList,
				new Pagination(result));
		} else {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}
	}

	@Override
	public DefaultResponse<SupplyResponseDto> getSupplyBySupplyId(String supplyId) {
		Optional<Supply> findBySupplyAsSupplyId = supplyRepository.findById(supplyId);

		if (findBySupplyAsSupplyId.isPresent()) {
			Supply supply = findBySupplyAsSupplyId.get();

			return DefaultResponse.response(
				HttpStatus.OK.value(),
				"OK",
				SupplyResponseDto.builder()
					.supplyId(supply.getSupplyId())
					.teamId(supply.getTeam().getTeamId())
					.build());
		}

		return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
	}

	@Override
	public DefaultResponse<List<SupplyResponseDto>> getSupplyByTeamId(Long teamId, Integer page, Integer size) {
		Page<SupplyResponseDto> findBySupplyAsTeamId = supplyQueryDslRepository.findBySupplyAsTeamId(teamId, PageRequest.of(page, size));

		if (ObjectUtil.checkObjectExistence(findBySupplyAsTeamId)) {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}

		List<SupplyResponseDto> supplyResponseDtoList = GraphQLSupportUtil.pageToList(findBySupplyAsTeamId);

		if (!supplyResponseDtoList.isEmpty()) {
			return DefaultResponse.response(
				HttpStatus.OK.value(),
				"OK",
				supplyResponseDtoList,
				new Pagination(findBySupplyAsTeamId));
		} else {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}
	}

	@Override
	public DefaultResponse<String> deleteSupply(String supplyId) {
		Optional<Supply> supplyByRepositoryById = supplyRepository.findById(supplyId);

		if (supplyByRepositoryById.isPresent()) {
			supplyRepository.deleteById(supplyId);

			return DefaultResponse.response(HttpStatus.OK.value(), "Deleted Success", supplyId);
		}

		return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DELETE TARGET", supplyId);
	}
}
