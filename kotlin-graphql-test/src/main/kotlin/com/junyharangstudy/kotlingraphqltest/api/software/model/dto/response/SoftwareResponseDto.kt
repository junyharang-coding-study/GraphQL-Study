package com.junyharangstudy.kotlingraphqltest.api.software.model.dto.response

import com.junyharangstudy.kotlingraphqltest.api.software.model.entity.Software

class SoftwareResponseDto (
    private val softwareId: String,
    private val usedBy: String,
    private val developedBy: String,
    private val description: String?
) {
    companion object {
        fun softwareToDto(software: Software): SoftwareResponseDto {
            return SoftwareResponseDto(
                softwareId = software.softwareId,
                usedBy = software.usedBy,
                developedBy = software.developedBy,
                description = software.description)
        }
    }
}