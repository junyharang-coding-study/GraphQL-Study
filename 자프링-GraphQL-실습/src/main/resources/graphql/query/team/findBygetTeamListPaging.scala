query findBygetTeamListPaging {
  getTeamList(
    page: 1,
    size: 3
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}