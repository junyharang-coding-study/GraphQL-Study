package com.junyss.graphqltest.api.role.service;

import com.junyss.graphqltest.api.role.model.dto.request.RoleRequestDto;
import com.junyss.graphqltest.api.role.model.dto.request.RoleUpdateRequestDto;
import com.junyss.graphqltest.api.role.model.dto.response.RoleResponseDto;
import com.junyss.graphqltest.common.constant.DefaultResponse;

public interface RoleService {
	DefaultResponse<String> saveForRole(RoleRequestDto roleRequestDto);

	DefaultResponse<RoleResponseDto> getRoleByRoleId(String roleId);

	DefaultResponse<String> updateRole(RoleUpdateRequestDto roleUpdateRequestDto);

	DefaultResponse<String> deleteRole(String roleId);
}
