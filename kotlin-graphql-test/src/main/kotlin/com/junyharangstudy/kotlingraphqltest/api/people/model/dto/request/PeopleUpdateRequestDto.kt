package com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request

import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType
import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role
import com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex

class PeopleUpdateRequestDto (
    var teamId: Long?,
    var lastName: String?,
    var firstName: String?,
    var sex: Sex?,
    var bloodType: BloodType?,
    var serveYears: Int?,
    var role: Role?,
    var hometown: String?
)