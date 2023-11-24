package com.junyss.graphqltest.people.model.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.junyss.graphqltest.common.enumtype.BloodType;
import com.junyss.graphqltest.common.enumtype.Role;
import com.junyss.graphqltest.common.enumtype.Sex;

import lombok.Data;

@Data
public class PeopleRequestDto {
	@NotBlank private Long teamId;
	@NotBlank private String lastName;
	@NotBlank private String firstName;
	@NotBlank private Sex sex;
	@NotBlank private BloodType bloodType;
	@NotNull @Min(0) private Integer serveYears;
	@NotBlank private Role role;
	@NotBlank private String hometown;
}
