mutation savePeople {
  savePeople(input: {
    teamId: 1,
    lastName: "H",
    firstName: "Juny",
    sex: male,
    bloodType: B,
    serveYears: 10,
    role: developer,
    hometown: "Seoul"
  }) {
    statusCode,
    message,
    data
  }
}