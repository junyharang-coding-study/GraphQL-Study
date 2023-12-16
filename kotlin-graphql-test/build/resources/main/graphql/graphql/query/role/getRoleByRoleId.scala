query getRoleByRoleId {
  getRoleByRoleId(roleId: "developer") {
    statusCode,
    message,
    data {
      roleId,
      job,
      requirement
    }
  }
}