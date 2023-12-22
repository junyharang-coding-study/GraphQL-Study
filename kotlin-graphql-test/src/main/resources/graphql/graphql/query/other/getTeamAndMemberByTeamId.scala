query getTeamAndMemberByTeamId {
  getTeamAndMemberByTeamId(teamId: 1) {
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
        firstName,
        lastName,
        sex,
        bloodType,
        serveYears,
        role,
        hometown
      }
    }
  }
}