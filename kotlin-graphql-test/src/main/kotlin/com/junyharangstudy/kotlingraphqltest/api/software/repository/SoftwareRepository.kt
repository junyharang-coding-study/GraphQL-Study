package com.junyharangstudy.kotlingraphqltest.api.software.repository

import com.junyharangstudy.kotlingraphqltest.api.software.model.entity.Software
import org.springframework.data.jpa.repository.JpaRepository

interface SoftwareRepository: JpaRepository<Software, String>