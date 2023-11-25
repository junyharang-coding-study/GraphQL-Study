package com.junyss.graphqltest.api.role.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.junyss.graphqltest.api.role.model.dto.request.RoleRequestDto;
import com.junyss.graphqltest.api.role.model.dto.request.RoleUpdateRequestDto;
import com.junyss.graphqltest.api.role.model.dto.response.RoleResponseDto;
import com.junyss.graphqltest.api.role.resolver.RoleResolver;
import com.junyss.graphqltest.common.constant.DefaultResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class RoleController {

	private final RoleResolver roleResolver;

	@MutationMapping
	public DefaultResponse<String> saveForRole (@Argument("input") RoleRequestDto roleRequestDto) {
		return roleResolver.saveForRole(roleRequestDto);
	}

	@QueryMapping
	public DefaultResponse<RoleResponseDto> getRoleByRoleId (@Argument String roleId) {
		return roleResolver.getRoleByRoleId(roleId);
	}

	@MutationMapping
	public DefaultResponse<String> updateRole (@Argument("input") RoleUpdateRequestDto roleUpdateRequestDto) {
		return roleResolver.updateRole(roleUpdateRequestDto);
	}

	@MutationMapping
	public DefaultResponse<String> deleteRole (@Argument String roleId) {
		return roleResolver.deleteRole(roleId);
	}
}
