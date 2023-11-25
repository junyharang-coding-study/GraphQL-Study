package com.junyss.graphqltest.api.software.model.dto.request;

import lombok.Data;

@Data
public class SoftwareUpdateRequestDto {
	private String softwareId;
	private String usedBy;
	private String developedBy;
	private String description;
}
