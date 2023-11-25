mutation updateTeam {
  updateTeam(input: {
    teamId: 6
    office: "201A",
    extensionNumber: "#0724",
    mascot: "Dog"
  }) {
    statusCode,
    message,
    data
  }
}