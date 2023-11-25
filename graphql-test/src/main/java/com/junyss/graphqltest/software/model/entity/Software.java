package com.junyss.graphqltest.software.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.junyss.graphqltest.software.model.dto.request.SoftwareRequestDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Software {

	@Id private String softwareId;
	private String usedBy;
	private String developedBy;
	private String description;

	public static Software toEntity (SoftwareRequestDto softwareRequestDto) {
		return new Software(
			softwareRequestDto.getSoftwareId(),
			softwareRequestDto.getUsedBy(),
			softwareRequestDto.getDevelopedBy(),
			softwareRequestDto.getDescription());
	}

	public void updateUsedBy(String usedBy) {
		this.usedBy = usedBy;
	}

	public void updateDevelopedBy(String developedBy) {
		this.developedBy = developedBy;
	}

	public void updateDescription(String description) {
		this.description = description;
	}
}
