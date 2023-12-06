mutation updateRole {
  updateRole(input: {
    roleId: "CTO"
    job: "Chief Executive Officer"
    requirement: "Chief Executive Officer"
  }) {
    statusCode,
    message,
    data
  }
}