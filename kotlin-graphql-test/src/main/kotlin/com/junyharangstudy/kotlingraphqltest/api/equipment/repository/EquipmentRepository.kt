package com.junyharangstudy.kotlingraphqltest.api.equipment.repository

import com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment
import org.springframework.data.jpa.repository.JpaRepository

interface EquipmentRepository: JpaRepository<Equipment, String>