package com.junyharangstudy.kotlingraphqltest.api.people.repository

import com.junyharangstudy.kotlingraphqltest.api.people.model.entity.People
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PeopleRepository: JpaRepository<People, Long> {
    @Query(value = "SELECT people FROM People people where people.team.teamId = :teamId")
    fun findAllByTeamId(@Param("teamId") teamId: Long): List<People>
}