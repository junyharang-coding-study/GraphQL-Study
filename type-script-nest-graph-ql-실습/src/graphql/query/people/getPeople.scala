query getPeople {
  getPeople(peopleId: 2) {
    statusCode,
    message,
    data {
      peopleId,
      teamId,
      lastName,
      firstName,
      sex,
      bloodType,
      serveYears,
      role,
      hometown
    }
  }
}