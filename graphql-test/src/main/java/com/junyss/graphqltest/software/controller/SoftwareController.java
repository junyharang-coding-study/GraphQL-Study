package com.junyss.graphqltest.software.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.software.model.dto.request.SoftwareRequestDto;
import com.junyss.graphqltest.software.model.dto.request.SoftwareUpdateRequestDto;
import com.junyss.graphqltest.software.model.dto.response.SoftwareResponseDto;
import com.junyss.graphqltest.software.resolver.SoftwareResolver;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SoftwareController {

	private final SoftwareResolver softwareResolver;

	@MutationMapping
	public DefaultResponse<String> saveForSoftware (@Argument("input") SoftwareRequestDto softwareRequestDto) {
		return softwareResolver.saveForSoftware(softwareRequestDto);
	}

	@QueryMapping
	public DefaultResponse<List<SoftwareResponseDto>> getSoftwareList (
		@Argument String usedBy,
		@Argument String developedBy,
		@Argument Integer page,
		@Argument Integer size){

		return softwareResolver.getSoftwareList(
			usedBy,
			developedBy,
			page,
			size);
	}

	@QueryMapping
	public DefaultResponse<SoftwareResponseDto> getSoftwareBySoftwareId (@Argument String softwareId) {
		return softwareResolver.getSoftwareBySoftwareId(softwareId);
	}

	@MutationMapping
	public DefaultResponse<String> updateSoftware (@Argument("input") SoftwareUpdateRequestDto softwareUpdateRequestDto) {
		return softwareResolver.updateSoftware(softwareUpdateRequestDto);
	}

	@MutationMapping
	public DefaultResponse<String> deleteSoftware (@Argument String softwareId) {
		return softwareResolver.deleteSoftware(softwareId);
	}
}