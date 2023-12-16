mutation saveRole {
  saveRole(input: {
    roleId: "frontEndDeveloper",
    job: "FeProgrammer",
    requirement: "Web/App FrontEnd Develop"
  }) {
    statusCode,
    message,
    data
  }
}