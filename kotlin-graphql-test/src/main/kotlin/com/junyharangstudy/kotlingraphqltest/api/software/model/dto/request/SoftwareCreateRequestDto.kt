package com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request

import com.junyharangstudy.kotlingraphqltest.api.software.model.entity.Software
import jakarta.validation.constraints.NotBlank

class SoftwareCreateRequestDto (
    @NotBlank val softwareId: String,
    @NotBlank val usedBy: String,
    @NotBlank val developedBy: String,
    val description: String?
) {
    fun toEntity(softwareCreateDto: SoftwareCreateRequestDto): Software {
        return Software(
            softwareCreateDto.softwareId,
            softwareCreateDto.usedBy,
            softwareCreateDto.developedBy,
            softwareCreateDto.description)
    }
}