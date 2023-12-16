package com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request

import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType
import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role
import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex

class PeopleSearchRequestDto (
    val lastName: String?,
    val firstName: String?,
    val sex: Sex?,
    val bloodType: BloodType?,
    val serveYears: Int?,
    val role: Role?,
    val hometown: String?
)