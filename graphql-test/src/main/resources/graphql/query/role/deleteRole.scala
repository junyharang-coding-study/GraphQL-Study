mutation deleteRole {
  deleteRole(roleId: "designer") {
    statusCode,
    message,
    data
  }
}