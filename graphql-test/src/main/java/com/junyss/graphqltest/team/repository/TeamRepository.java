package com.junyss.graphqltest.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junyss.graphqltest.team.model.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {}
