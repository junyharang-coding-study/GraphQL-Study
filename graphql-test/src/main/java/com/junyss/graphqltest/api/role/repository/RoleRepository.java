package com.junyss.graphqltest.api.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.junyss.graphqltest.api.role.model.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
	@Modifying
	@Query(value = "INSERT INTO ROLE (ROLE_ID, JOB, REQUIREMENT) VALUES (:#{#role.roleId}, :#{#role.job}, :#{#role.requirement})", nativeQuery = true)
	Integer customSave(@Param("role") Role role);
}
