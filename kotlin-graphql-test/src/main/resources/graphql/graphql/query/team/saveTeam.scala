mutation saveTeam {
  saveTeam(input: {
    manager: "Juny",
    office: "	104B",
    extensionNumber: "#3170",
    mascot: "Tiger",
    cleaningDuty: "Friday",
    project: "Junyss"
  }) {
    statusCode,
    message,
    data
  }
}