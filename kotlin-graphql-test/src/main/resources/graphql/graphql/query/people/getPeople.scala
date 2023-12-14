query getPeopleByPeopleId {
  getPeopleByPeopleId(peopleId: 1) {
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