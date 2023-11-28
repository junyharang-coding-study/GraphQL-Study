package com.junyss.graphqltest.api.people.resolver;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.junyss.graphqltest.api.people.model.dto.request.PeopleRequestDto;
import com.junyss.graphqltest.api.people.model.dto.response.PeopleResponseDto;
import com.junyss.graphqltest.api.people.service.PeopleService;
import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.common.enumtype.BloodType;
import com.junyss.graphqltest.common.enumtype.Role;
import com.junyss.graphqltest.common.enumtype.Sex;
import com.junyss.graphqltest.api.people.model.dto.request.PeopleUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PeopleResolver {

	private final PeopleService peopleService;

	@MutationMapping
	public DefaultResponse<Long> saveForPeople (@Argument("input") PeopleRequestDto peopleRequestDtoDto) {
		return peopleService.saveForPeople(peopleRequestDtoDto);
	}

	@QueryMapping
	public DefaultResponse<List<PeopleResponseDto>> getPeopleList (
		@Argument Long peopleId,
		@Argument Long team,
		@Argument String lastName,
		@Argument String firstName,
		@Argument Sex sex,
		@Argument BloodType bloodType,
		@Argument Integer serveYears,
		@Argument Role role,
		@Argument String hometown,
		@Argument Integer page,
		@Argument Integer size) {

		return peopleService.getPeopleList(
			peopleId,
			team,
			lastName,
			firstName,
			sex,
			bloodType,
			serveYears,
			role,
			hometown,
			page,
			size);
	}

	@QueryMapping
	public DefaultResponse<PeopleResponseDto> getPeopleByPeopleId (@Argument Long peopleId) {
		return peopleService.getPeopleByPeopleId(peopleId);
	}

	@QueryMapping
	public DefaultResponse<List<PeopleResponseDto>> getPeopleByTeamId (
		@Argument Long teamId,
		@Argument Integer page,
		@Argument Integer size) {

		return peopleService.getPeopleByTeamId(teamId, page, size);
	}

	@MutationMapping
	public DefaultResponse<Long> updatePeople (@Argument("input") PeopleUpdateRequestDto peopleUpdateRequestDto) {
		return peopleService.updatePeople(peopleUpdateRequestDto);
	}

	@MutationMapping
	public DefaultResponse<Long> deletePeople (@Argument Long peopleId) {
		return peopleService.deletePeople(peopleId);
	}
}
