package com.junyss.graphqltest.api.role.resolver;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junyss.graphqltest.api.role.model.dto.request.RoleRequestDto;
import com.junyss.graphqltest.api.role.model.dto.request.RoleUpdateRequestDto;
import com.junyss.graphqltest.api.role.model.dto.response.RoleResponseDto;
import com.junyss.graphqltest.api.role.model.entity.Role;
import com.junyss.graphqltest.api.role.repository.RoleRepository;
import com.junyss.graphqltest.common.constant.DefaultResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RoleResolverImpl implements RoleResolver {

	private final RoleRepository roleRepository;

	@Transactional
	@Override
	public DefaultResponse<String> saveForRole(RoleRequestDto roleRequestDto) {
		if (roleRequestDto == null) {
			return DefaultResponse.response(HttpStatus.NO_CONTENT.value(), "Failed Create");
		}

		Integer returnStatus = roleRepository.customSave(
			Role.toEntity(
				roleRequestDto.getRoleId(),
				roleRequestDto.getJob(),
				roleRequestDto.getRequirement()));

		if (returnStatus != null && returnStatus == 1) {
			return DefaultResponse.response(
				HttpStatus.CREATED.value(),
				"Success Create");
		}

		return DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed Create");
	}

	@Transactional(readOnly = true)
	@Override
	public DefaultResponse<RoleResponseDto> getRoleByRoleId(String roleId) {
		Optional<Role> findByRoleAsRoleId = roleRepository.findById(roleId);

		if (findByRoleAsRoleId.isPresent()) {
			Role role = findByRoleAsRoleId.get();

			return DefaultResponse.response(
				HttpStatus.OK.value(),
				"OK",
				RoleResponseDto.builder()
					.roleId(role.getRoleId())
					.job(role.getJob())
					.requirement(role.getRequirement())
					.build());
		}

		return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
	}

	@Transactional
	@Override
	public DefaultResponse<String> updateRole(RoleUpdateRequestDto roleUpdateRequestDto) {
		Optional<Role> roleRepositoryById = roleRepository.findById(roleUpdateRequestDto.getRoleId());

		Role role = checkUpdateRequest(roleUpdateRequestDto, roleRepositoryById);

		if (role == null) {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET");
		}

		return DefaultResponse.response(
			HttpStatus.OK.value(),
			"Success Update",
			roleRepository.save(role).getRoleId());
	}

	@Transactional
	@Override
	public DefaultResponse<String> deleteRole(String roleId) {
		Optional<Role> roleRepositoryById = roleRepository.findById(roleId);

		if (roleRepositoryById.isPresent()) {
			roleRepository.deleteById(roleId);

			return DefaultResponse.response(HttpStatus.OK.value(), "Deleted Success", roleId);
		}

		return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DELETE TARGET", roleId);
	}

	private Role checkUpdateRequest(RoleUpdateRequestDto roleUpdateRequestDto, Optional<Role> roleRepositoryById) {
		if (roleRepositoryById.isEmpty() || roleUpdateRequestDto.getRoleId() == null) {
			return null;
		} else {
			Role role = roleRepositoryById.get();

			if (roleUpdateRequestDto.getJob() != null) {
				role.updateJob(roleUpdateRequestDto.getJob());
			}

			if (roleUpdateRequestDto.getRequirement() != null) {
				role.updateRequirement(roleUpdateRequestDto.getRequirement());
			}

			return role;
		}
	}
}
