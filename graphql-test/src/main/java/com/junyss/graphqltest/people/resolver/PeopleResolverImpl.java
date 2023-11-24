package com.junyss.graphqltest.people.resolver;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junyss.graphqltest.common.constant.DefaultResponse;
import com.junyss.graphqltest.common.constant.Pagination;
import com.junyss.graphqltest.common.enumtype.BloodType;
import com.junyss.graphqltest.common.enumtype.Role;
import com.junyss.graphqltest.common.enumtype.Sex;
import com.junyss.graphqltest.common.util.GraphQLSupportUtil;
import com.junyss.graphqltest.common.util.PagingProcessUtil;
import com.junyss.graphqltest.people.model.dto.request.PeopleRequestDto;
import com.junyss.graphqltest.people.model.dto.request.PeopleSearchRequestDto;
import com.junyss.graphqltest.people.model.dto.request.PeopleUpdateRequestDto;
import com.junyss.graphqltest.people.model.dto.response.PeopleResponseDto;
import com.junyss.graphqltest.people.model.entity.People;
import com.junyss.graphqltest.people.repository.PeopleQueryDslRepository;
import com.junyss.graphqltest.people.repository.PeopleRepository;
import com.junyss.graphqltest.team.model.entity.Team;
import com.junyss.graphqltest.team.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PeopleResolverImpl implements PeopleResolver {

	private final PeopleRepository peopleRepository;
	private final PeopleQueryDslRepository peopleQueryDslRepository;
	private final TeamRepository teamRepository;

	@Transactional
	@Override
	public DefaultResponse<Long> saveForPeople(PeopleRequestDto peopleRequestDtoDto) {

		Optional<Team> team = teamRepository.findById(peopleRequestDtoDto.getTeamId());

		if (team.isPresent()) {
			if (peopleRequestDtoDto == null) {
				return DefaultResponse.response(HttpStatus.NO_CONTENT.value(), "Failed Create");
			}

			return DefaultResponse.response(
				HttpStatus.CREATED.value(),
				"Success Create",
				peopleRepository.save(
						People.toEntity(
							team.get(),
							peopleRequestDtoDto.getLastName(),
							peopleRequestDtoDto.getFirstName(),
							peopleRequestDtoDto.getSex(),
							peopleRequestDtoDto.getBloodType(),
							peopleRequestDtoDto.getServeYears(),
							peopleRequestDtoDto.getRole(),
							peopleRequestDtoDto.getHometown()))
					.getPeopleId());
		}
		return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "Failed Create");
	}

	@Transactional(readOnly = true)
	@Override
	public DefaultResponse<List<PeopleResponseDto>> getPeopleList(
		Long peopleId,
		Long teamId,
		String lastName,
		String firstName,
		Sex sex,
		BloodType bloodType,
		Integer serveYears,
		Role role,
		String hometown,
		Integer page,
		Integer size) {

		Page<PeopleResponseDto> result = peopleQueryDslRepository.findBySearchAndPaging(
			new PeopleSearchRequestDto(
				peopleId,
				teamId,
				lastName,
				firstName,
				sex,
				bloodType,
				serveYears,
				role,
				hometown),
			PagingProcessUtil.processPaging(page, size));

		if (result.getTotalElements() == 0 && !result.hasContent()) {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}

		List<PeopleResponseDto> peopleResponseDtoList = GraphQLSupportUtil.pageToList(result);

		if (!peopleResponseDtoList.isEmpty()) {
			return DefaultResponse.response(
				HttpStatus.OK.value(),
				"OK",
				peopleResponseDtoList,
				new Pagination(result));
		} else {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
		}
	}

	@Transactional(readOnly = true)
	@Override
	public DefaultResponse<PeopleResponseDto> getPeople(Long peopleId) {
		Optional<People> findByPeople = peopleRepository.findById(peopleId);

		if (findByPeople.isPresent()) {
			People people = findByPeople.get();

			return DefaultResponse.response(
				HttpStatus.OK.value(),
				"OK",
				PeopleResponseDto.builder()
					.peopleId(people.getPeopleId())
					.teamId(people.getTeam().getTeamId())
					.lastName(people.getLastName())
					.firstName(people.getFirstName())
					.sex(Sex.valueOf(String.valueOf(people.getSex())))
					.bloodType(BloodType.valueOf(String.valueOf(people.getBloodType())))
					.serveYears(people.getServeYears())
					.role(Role.valueOf(String.valueOf(people.getRole())))
					.hometown(people.getHometown())
					.build());
		}

		return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DATA");
	}

	@Transactional
	@Override
	public DefaultResponse<Long> updatePeople(PeopleUpdateRequestDto peopleUpdateRequestDto) {
		Optional<People> peopleRepositoryById = peopleRepository.findById(peopleUpdateRequestDto.getPeopleId());

		People people = checkUpdateRequest(peopleUpdateRequestDto, peopleRepositoryById);

		if (people == null) {
			return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND UPDATE TARGET");
		}

		return DefaultResponse.response(
			HttpStatus.OK.value(),
			"Success Update",
			peopleRepository.save(people).getPeopleId());
	}

	@Transactional
	@Override
	public DefaultResponse<Long> deletePeople(Long peopleId) {
		Optional<People> peopleRepositoryById = peopleRepository.findById(peopleId);

		if (peopleRepositoryById.isPresent()) {
			peopleRepository.deleteById(peopleId);

			return DefaultResponse.response(HttpStatus.OK.value(), "Deleted Success", peopleId);
		}

		return DefaultResponse.response(HttpStatus.NOT_FOUND.value(), "NOT FOUND DELETE TARGET", peopleId);
	}

	private People checkUpdateRequest(PeopleUpdateRequestDto peopleUpdateRequestDto,
		Optional<People> peopleRepositoryById) {
		if (peopleRepositoryById.isEmpty() || peopleUpdateRequestDto.getPeopleId() == null) {
			return null;
		} else {
			People people = peopleRepositoryById.get();

			if (peopleUpdateRequestDto.getLastName() != null) {
				people.updateLastName(peopleUpdateRequestDto.getLastName());
			}

			if (peopleUpdateRequestDto.getFirstName() != null) {
				people.updateFirstName(peopleUpdateRequestDto.getFirstName());
			}

			if (peopleUpdateRequestDto.getSex() != null) {
				people.updateSex(peopleUpdateRequestDto.getSex());
			}

			if (peopleUpdateRequestDto.getBloodType() != null) {
				people.updateBloodType(peopleUpdateRequestDto.getBloodType());
			}

			if (peopleUpdateRequestDto.getServeYears() != null) {
				people.updateServeYears(peopleUpdateRequestDto.getServeYears());
			}

			if (peopleUpdateRequestDto.getRole() != null) {
				people.updateRole(peopleUpdateRequestDto.getRole());
			}

			if (peopleUpdateRequestDto.getHometown() != null) {
				people.updateHomeTown(peopleUpdateRequestDto.getHometown());
			}
			return people;
		}
	}
}
