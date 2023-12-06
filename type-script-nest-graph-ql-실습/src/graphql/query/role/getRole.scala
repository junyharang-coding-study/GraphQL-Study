query getRole {
  getRole(roleId: "developer") {
    statusCode,
    message,
    data {
      roleId,
      job,
      requirement
    }
  }
}