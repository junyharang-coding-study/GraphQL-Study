package com.junyss.graphqltest.api.role.model.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RoleRequestDto {
	@NotBlank private String roleId;
	@NotBlank private String job;
	@NotBlank private String requirement;
}
