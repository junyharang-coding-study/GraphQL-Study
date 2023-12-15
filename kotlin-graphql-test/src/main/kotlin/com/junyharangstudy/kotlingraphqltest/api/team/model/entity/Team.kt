package com.junyharangstudy.kotlingraphqltest.api.team.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Team(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val teamId: Long?,
    var manager: String,
    var office: String,
    var mascot: String,
    var extensionNumber: String,
    var cleaningDuty: String,
    var project: String
) {
    fun updateManager(manager: String) {
        this.manager = manager
    }

    fun updateOffice(office: String) {
        this.office = office
    }

    fun updateMascot(mascot: String) {
        this.mascot = mascot
    }

    fun updateExtensionNumber(extensionNumber: String) {
        this.extensionNumber = extensionNumber
    }

    fun updateCleaningDuty(cleaningDuty: String) {
        this.cleaningDuty = cleaningDuty
    }

    fun updateProject(project: String) {
        this.project = project
    }
}