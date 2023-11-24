package com.junyss.graphqltest.people.model.dto.request;

import com.junyss.graphqltest.common.enumtype.BloodType;
import com.junyss.graphqltest.common.enumtype.Role;
import com.junyss.graphqltest.common.enumtype.Sex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleSearchRequestDto {
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
