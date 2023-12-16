package com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Equipment(
    @Id val equipmentId: String,
    var usedBy: String,
    var count: Int,
    var newOrUsed: String
) {

    fun updateUsedBy(usedBy: String) {
        this.usedBy = usedBy
    }

    fun updateCount(count: Int) {
        this.count = count
    }

    fun updateNewOrUsed(newOrUsed: String) {
        this.newOrUsed = newOrUsed
    }
}