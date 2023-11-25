package com.junyss.graphqltest.api.software.resolver;

import java.util.List;

import com.junyss.graphqltest.api.software.model.dto.response.SoftwareResponseDto;
import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.api.software.model.dto.request.SoftwareRequestDto;
import com.junyss.graphqltest.api.software.model.dto.request.SoftwareUpdateRequestDto;

public interface SoftwareResolver {
	DefaultResponse<String> saveForSoftware(SoftwareRequestDto softwareRequestDto);

	DefaultResponse<List<SoftwareResponseDto>> getSoftwareList(
		String usedBy,
		String developedBy,
		Integer page,
		Integer size);

	DefaultResponse<SoftwareResponseDto> getSoftwareBySoftwareId(String softwareId);

	DefaultResponse<String> updateSoftware(SoftwareUpdateRequestDto softwareUpdateRequestDto);

	DefaultResponse<String> deleteSoftware(String softwareId);
}
