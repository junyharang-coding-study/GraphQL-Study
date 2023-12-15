mutation updateTeam {
  updateTeam(
    teamId: 6,
    input: {
      office: "201A",
      extensionNumber: "#0724",
      mascot: "Dog"
    }) {
    statusCode,
    message,
    data
  }
}