package com.junyss.graphqltest.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junyss.graphqltest.people.model.entity.People;

public interface PeopleRepository extends JpaRepository<People, Long> {}
