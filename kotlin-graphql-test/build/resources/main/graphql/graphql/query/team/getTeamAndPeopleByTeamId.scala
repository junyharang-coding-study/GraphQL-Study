query getTeamAndPeopleByTeamId {
  getTeamByTeamId(teamId: 1) {
    statusCode,
    message,
    data {
      teamId,
      manager,
      office,
      extensionNumber,
      mascot

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