query getTeamAndMembersByTeamId {
  getTeamAndMembersByTeamIdOrNothing(teamId: 1) {
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