package com.junyss.graphqltest.api.people.model.dto.request;

import com.junyss.graphqltest.common.enumtype.BloodType;
import com.junyss.graphqltest.common.enumtype.Role;
import com.junyss.graphqltest.common.enumtype.Sex;

import lombok.Data;

@Data
public class PeopleUpdateRequestDto {
	private Long peopleId;
	private Long teamId;
	private String lastName;
	private String firstName;
	private Sex sex;
	private BloodType bloodType;
	private Integer serveYears;
    private Role role;
	private String hometown;
}
