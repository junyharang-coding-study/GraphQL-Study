query getTeamAndMembers {
  getTeamAndMembersByTeamIdOrNothing {
    statusCode,
    message,
    data {
      teamId,
      manager,
      office,
      extensionNumber,
      mascot,
      cleaningDuty,
      project,
      members {
        peopleId,
        teamId,
        lastName,
        firstName,
        sex,
        bloodType,
        serveYears,
        role,
        hometown,
      }
    }
  }
}