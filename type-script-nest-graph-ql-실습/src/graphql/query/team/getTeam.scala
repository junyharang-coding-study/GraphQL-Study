query getTeam {
  getTeam(teamId: 1) {
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
    }
  }
}