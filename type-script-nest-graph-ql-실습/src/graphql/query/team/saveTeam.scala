mutation saveTeam {
  saveTeam(input: {
    manager: "Juny H",
    office: "105A",
    extensionNumber: "#0724",
    mascot: "Tiger",
    cleaningDuty: "Friday",
    project: "Spring Boot",
  }) {
    statusCode,
    message,
    data
  }
}