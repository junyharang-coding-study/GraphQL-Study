package com.junyss.graphqltest.software.resolver;

import java.util.List;

import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.people.model.dto.response.PeopleResponseDto;
import com.junyss.graphqltest.software.model.dto.request.SoftwareRequestDto;
import com.junyss.graphqltest.software.model.dto.request.SoftwareUpdateRequestDto;
import com.junyss.graphqltest.software.model.dto.response.SoftwareResponseDto;

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
