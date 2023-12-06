mutation deleteRole {
  deleteRole(roleId: "CTO") {
    statusCode,
    message,
    data
  }
}