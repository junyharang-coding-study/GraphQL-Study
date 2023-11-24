package com.junyss.graphqltest.people.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.common.enumtype.BloodType;
import com.junyss.graphqltest.common.enumtype.Role;
import com.junyss.graphqltest.common.enumtype.Sex;
import com.junyss.graphqltest.people.model.dto.request.PeopleRequestDto;
import com.junyss.graphqltest.people.model.dto.request.PeopleUpdateRequestDto;
import com.junyss.graphqltest.people.model.dto.response.PeopleResponseDto;
import com.junyss.graphqltest.people.resolver.PeopleResolver;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PeopleController {

	private final PeopleResolver peopleResolver;

	@MutationMapping
	public DefaultResponse<Long> saveForPeople (@Argument("input") PeopleRequestDto peopleRequestDtoDto) {
		return peopleResolver.saveForPeople(peopleRequestDtoDto);
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

		return peopleResolver.getPeopleList(
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
	public DefaultResponse<PeopleResponseDto> getPeople (@Argument Long peopleId) {
		return peopleResolver.getPeople(peopleId);
	}

	@MutationMapping
	public DefaultResponse<Long> updatePeople (@Argument("input") PeopleUpdateRequestDto peopleUpdateRequestDto) {
		return peopleResolver.updatePeople(peopleUpdateRequestDto);
	}

	@MutationMapping
	public DefaultResponse<Long> deletePeople (@Argument Long peopleId) {
		return peopleResolver.deletePeople(peopleId);
	}
}
