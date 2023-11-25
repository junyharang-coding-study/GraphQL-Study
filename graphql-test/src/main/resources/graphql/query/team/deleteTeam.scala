mutation deleteTeam {
  updateTeam(input: {
    teamId: 1
  }) {
    statusCode,
    message,
    data
  }
}