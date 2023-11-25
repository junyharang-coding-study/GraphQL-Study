package com.junyss.graphqltest.people.resolver;

import java.util.List;

import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.common.enumtype.BloodType;
import com.junyss.graphqltest.common.enumtype.Role;
import com.junyss.graphqltest.common.enumtype.Sex;
import com.junyss.graphqltest.people.model.dto.request.PeopleRequestDto;
import com.junyss.graphqltest.people.model.dto.request.PeopleUpdateRequestDto;
import com.junyss.graphqltest.people.model.dto.response.PeopleResponseDto;

public interface PeopleResolver {
	DefaultResponse<Long> saveForPeople(PeopleRequestDto peopleRequestDtoDto);

	DefaultResponse<List<PeopleResponseDto>> getPeopleList(
		Long peopleId,
		Long team,
		String lastName,
		String firstName,
		Sex sex,
		BloodType bloodType,
		Integer serveYears,
		Role role,
		String hometown,
		Integer page,
		Integer size);

	DefaultResponse<PeopleResponseDto> getPeopleByPeopleId(Long peopleId);

	DefaultResponse<List<PeopleResponseDto>> getPeopleByTeamId(Long teamId, Integer page, Integer size);

	DefaultResponse<Long> updatePeople(PeopleUpdateRequestDto peopleUpdateRequestDto);

	DefaultResponse<Long> deletePeople(Long peopleId);
}
