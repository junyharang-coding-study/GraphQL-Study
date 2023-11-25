mutation updatePeople {
  updatePeople(input: {
    peopleId: 51,
    teamId: 5,
    lastName: "H"
    firstName: "Junyss",
    serveYears: 20,
  }) {
    statusCode
    ,
    message
    ,
    data
  }
}