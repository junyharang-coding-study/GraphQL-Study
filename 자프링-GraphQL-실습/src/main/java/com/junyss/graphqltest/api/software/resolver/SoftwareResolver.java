package com.junyss.graphqltest.api.software.resolver;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.api.software.model.dto.request.SoftwareRequestDto;
import com.junyss.graphqltest.api.software.model.dto.request.SoftwareUpdateRequestDto;
import com.junyss.graphqltest.api.software.model.dto.response.SoftwareResponseDto;
import com.junyss.graphqltest.api.software.service.SoftwareService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SoftwareResolver {

	private final SoftwareService softwareService;

	@MutationMapping
	public DefaultResponse<String> saveForSoftware (@Argument("input") SoftwareRequestDto softwareRequestDto) {
		return softwareService.saveForSoftware(softwareRequestDto);
	}

	@QueryMapping
	public DefaultResponse<List<SoftwareResponseDto>> getSoftwareList (
		@Argument String usedBy,
		@Argument String developedBy,
		@Argument Integer page,
		@Argument Integer size){

		return softwareService.getSoftwareList(
			usedBy,
			developedBy,
			page,
			size);
	}

	@QueryMapping
	public DefaultResponse<SoftwareResponseDto> getSoftwareBySoftwareId (@Argument String softwareId) {
		return softwareService.getSoftwareBySoftwareId(softwareId);
	}

	@MutationMapping
	public DefaultResponse<String> updateSoftware (@Argument("input") SoftwareUpdateRequestDto softwareUpdateRequestDto) {
		return softwareService.updateSoftware(softwareUpdateRequestDto);
	}

	@MutationMapping
	public DefaultResponse<String> deleteSoftware (@Argument String softwareId) {
		return softwareService.deleteSoftware(softwareId);
	}
}