package com.junyss.graphqltest.software.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.junyss.graphqltest.software.model.entity.Software;

public interface SoftwareRepository extends JpaRepository<Software, String> {
	@Query(value = "select software from Software software where software.softwareId = :softwareId")
	Optional<Software> findBySoftwareId(String softwareId);
}
