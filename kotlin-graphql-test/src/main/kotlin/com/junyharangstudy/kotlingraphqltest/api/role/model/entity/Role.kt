package com.junyharangstudy.kotlingraphqltest.api.role.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Role (
    @Id var roleId: String,
    var job: String,
    var requirement: String
) {
    fun updateJob(job: String) {
        this.job = job
    }

    fun updateRequirment(requirement: String) {
        this.requirement = requirement
    }
}