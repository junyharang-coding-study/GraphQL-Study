mutation updateRole {
  updateRole(input: {
    roleId: "developer",
    job: "programmer"
  }) {
    statusCode,
    message,
    data
  }
}