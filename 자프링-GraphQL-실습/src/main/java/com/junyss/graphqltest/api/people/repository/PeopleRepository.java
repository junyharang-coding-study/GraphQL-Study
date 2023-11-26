package com.junyss.graphqltest.api.people.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.junyss.graphqltest.api.people.model.entity.People;

public interface PeopleRepository extends JpaRepository<People, Long> {
	@Query(value = "SELECT people FROM People people where people.team.teamId = :teamId")
	List<People> findAllByTeamId(@Param("teamId") Long teamId);
}
