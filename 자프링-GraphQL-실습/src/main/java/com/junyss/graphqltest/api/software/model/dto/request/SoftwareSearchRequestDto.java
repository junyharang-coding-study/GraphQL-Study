package com.junyss.graphqltest.api.software.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoftwareSearchRequestDto {
	private String usedBy;
	private String developedBy;
}
