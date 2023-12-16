package com.junyharangstudy.kotlingraphqltest.api.supply.repository

import com.junyharangstudy.kotlingraphqltest.api.supply.model.entity.Supply
import org.springframework.data.jpa.repository.JpaRepository

interface SupplyRepository: JpaRepository<Supply, String>