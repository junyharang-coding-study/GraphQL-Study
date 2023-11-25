query findBygetTeamListSeachextensionNumberAndPaging {
  getTeamList(
    extensionNumber: "#3852",
    page: 1,
    size: 1
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}