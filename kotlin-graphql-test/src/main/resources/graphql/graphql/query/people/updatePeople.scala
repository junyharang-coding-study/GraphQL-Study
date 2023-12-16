mutation updatePeople {
  updatePeople(
    peopleId: 51,
    input: {
    teamId: 5,
    lastName: "H"
    firstName: "Junyss",
    serveYears: 20,
  }) {
    statusCode,
    message,
    data
  }
}