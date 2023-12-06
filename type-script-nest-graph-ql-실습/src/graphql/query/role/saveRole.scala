mutation saveRole {
  saveRole(input: {
    roleId: "CTO"
    job: "Chief Technical Officer"
    requirement: "Chief Technical Officer"
  }) {
    statusCode,
    message,
    data
  }
}