package com.junyss.graphqltest.api.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junyss.graphqltest.api.team.model.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {}
