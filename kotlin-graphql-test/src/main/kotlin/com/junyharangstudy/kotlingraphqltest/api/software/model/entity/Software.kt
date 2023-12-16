package com.junyharangstudy.kotlingraphqltest.api.software.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Software (
    @Id var softwareId: String,
    var usedBy: String,
    var developedBy: String,
    var description: String?
) {
    fun updateUsedBy(usedBy: String) {
        this.usedBy = usedBy
    }

    fun updateDevelopedBy(developedBy: String) {
        this.developedBy = developedBy
    }

    fun updateDescription(description: String) {
        this.description = description
    }
}