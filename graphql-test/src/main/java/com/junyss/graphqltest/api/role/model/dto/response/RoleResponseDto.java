package com.junyss.graphqltest.api.role.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponseDto {
	private String roleId;
	private String job;
	private String requirement;
}
