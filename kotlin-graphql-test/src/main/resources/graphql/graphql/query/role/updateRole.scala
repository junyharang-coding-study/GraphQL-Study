mutation updateRole {
  updateRole(
    roleId: "developer",
    input: {
      job: "programmer"
    }) {
    statusCode,
    message,
    data
  }
}