package com.junyss.graphqltest.software.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoftwareResponseDto {
	private String softwareId;
	private String usedBy;
	private String developedBy;
	private String description;
}
