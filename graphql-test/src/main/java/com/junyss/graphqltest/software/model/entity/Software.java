package com.junyss.graphqltest.software.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Software {

	@Id private String SoftwareId;
	private String usedBy;
	private String developedBy;
	private String description;

	public Software toEntity (String id, String usedBy, String developedBy, String description) {
		return new Software(id, usedBy, developedBy, description);
	}
}
