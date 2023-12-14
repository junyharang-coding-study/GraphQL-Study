query findBygetTeamListSeachManagerAndPaging {
  getTeamList(
    manager: "Mandy Warren",
    page: 1,
    size: 1
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}