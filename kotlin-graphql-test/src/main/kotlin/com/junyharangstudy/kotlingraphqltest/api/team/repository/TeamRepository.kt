package com.junyharangstudy.kotlingraphqltest.api.team.repository

import com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository: JpaRepository<Team, Long>