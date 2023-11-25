package com.junyss.graphqltest.api.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junyss.graphqltest.api.people.model.entity.People;

public interface PeopleRepository extends JpaRepository<People, Long> {}
