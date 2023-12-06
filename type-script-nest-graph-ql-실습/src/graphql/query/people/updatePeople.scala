mutation updatePeople {
  updatePeople(input: {
    peopleId: 51,
    teamId: 5,
    lastName: "La",
    firstName: "Juny",
    serveYears: 20,
    hometown: "Seoul"
  }) {
    statusCode,
    message,
    data
  }
}