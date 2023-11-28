package com.junyss.graphqltest.api.software.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junyss.graphqltest.api.software.model.dto.request.SoftwareSearchRequestDto;
import com.junyss.graphqltest.api.software.model.dto.response.SoftwareResponseDto;
import com.junyss.graphqltest.api.software.model.entity.Software;
import com.junyss.graphqltest.api.software.repository.SoftwareQueryDslRepository;
import com.junyss.graphqltest.api.software.repository.SoftwareRepository;
import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.common.constant.Pagination;
import com.junyss.graphqltest.common.util.GraphQLSupportUtil;
import com.junyss.graphqltest.common.util.ObjectUtil;
import com.junyss.graphqltest.common.util.PagingProcessUtil;
import com.junyss.graphqltest.api.software.model.dto.request.SoftwareRequestDto;
import com.junyss.graphqltest.api.software.model.dto.request.SoftwareUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SoftwareServiceImpl implements SoftwareService {

	private final SoftwareRepository softwareRepository;
	private final SoftwareQueryDslRepository softwareQueryDslRepository;

	@Transactional
	@Override
	public DefaultResponse<String> saveForSoftware(SoftwareRequestDto softwareRequestDto) {
		if (softwareRequestDto == null) {
			return DefaultResponse.response(HttpStatus.NO_CONTENT.value(), "Failed Create");
		}

		return DefaultResponse.response(
			HttpStatus.CREATED.value(),
			"Success Create",
			softwareRepository.save(
					Software.toEntity(softwareRequestDto))
				.getSoftwareId());
	}

	@Transactional(readOnly = true)
	@Override
	public DefaultResponse<List<SoftwareResponseDto>> getSoftwareList(
		String usedBy,
		String developedBy,
		Integer page,
		Integer size) {

		Page<SoftwareResponseDto> result = softwareQueryDslRepository.findBySearchAndPaging(
			new SoftwareSearchRequestDto(
				usedBy,
				developedBy),
			PagingProcessUtil.processPaging(page, size));

		if (ObjectUtil.checkObjectExistence(result)) {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}

		List<SoftwareResponseDto> softwareResponseDtoList = GraphQLSupportUtil.pageToList(result);

		if (!softwareResponseDtoList.isEmpty()) {
			return DefaultResponse.response(
				HttpStatus.OK.value(),
				"OK",
				softwareResponseDtoList,
				new Pagination(result));
		} else {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}
	}

	@Transactional(readOnly = true)
	@Override
	public DefaultResponse<SoftwareResponseDto> getSoftwareBySoftwareId(String softwareId) {
		Optional<Software> findBySoftwareId = softwareRepository.findBySoftwareId(softwareId);

		if (findBySoftwareId.isPresent()) {
			Software software = findBySoftwareId.get();

			return DefaultResponse.response(
				HttpStatus.OK.value(),
				"OK",
				SoftwareResponseDto.builder()
					.softwareId(software.getSoftwareId())
					.usedBy(software.getUsedBy())
					.developedBy(software.getDevelopedBy())
					.description(software.getDescription())
					.build());
		}

		return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
	}

	@Transactional
	@Override
	public DefaultResponse<String> updateSoftware(SoftwareUpdateRequestDto softwareUpdateRequestDto) {
		Optional<Software> softwareRepositoryById = softwareRepository.findById(softwareUpdateRequestDto.getSoftwareId());

		Software software = checkUpdateRequest(softwareUpdateRequestDto, softwareRepositoryById);

		if (software == null) {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET");
		}

		return DefaultResponse.response(
			HttpStatus.OK.value(),
			"Success Update",
			softwareRepository.save(software).getSoftwareId());
	}

	@Transactional
	@Override
	public DefaultResponse<String> deleteSoftware(String softwareId) {
		Optional<Software> softwareRepositoryById = softwareRepository.findById(softwareId);

		if (softwareRepositoryById.isPresent()) {
			softwareRepository.deleteById(softwareId);

			return DefaultResponse.response(HttpStatus.OK.value(), "Deleted Success", softwareId);
		}

		return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DELETE TARGET", softwareId);
	}

	private Software checkUpdateRequest(SoftwareUpdateRequestDto softwareUpdateRequestDto, Optional<Software> softwareRepositoryById) {
		if (softwareRepositoryById.isEmpty()) {
			return null;
		} else {
			Software software = softwareRepositoryById.get();

			if (softwareUpdateRequestDto.getUsedBy() != null) {
				software.updateUsedBy(softwareUpdateRequestDto.getUsedBy());
			}

			if (softwareUpdateRequestDto.getDevelopedBy() != null) {
				software.updateDevelopedBy(softwareUpdateRequestDto.getDevelopedBy());
			}

			if (softwareUpdateRequestDto.getDescription() != null) {
				software.updateDescription(softwareUpdateRequestDto.getDescription());
			}

			return software;
		}
	}
}
