package com.junyharangstudy.kotlingraphqltest.api.role.repository

import com.junyharangstudy.kotlingraphqltest.api.role.model.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<Role, String>