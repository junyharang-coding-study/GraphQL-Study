package com.junyss.graphqltest.api.role.model.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RoleUpdateRequestDto {
	@NotBlank private String roleId;
	private String job;
	private String requirement;
}
