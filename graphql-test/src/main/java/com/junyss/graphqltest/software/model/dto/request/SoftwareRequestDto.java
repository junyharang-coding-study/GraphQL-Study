package com.junyss.graphqltest.software.model.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SoftwareRequestDto {
	@NotBlank private String softwareId;
	@NotBlank private String usedBy;
	@NotBlank private String developedBy;
	@NotBlank private String description;
}
