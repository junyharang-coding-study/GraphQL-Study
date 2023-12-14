query findBygetTeamListSeachOfficeAndPaging {
  getTeamList(
    office: "101A",
    page: 1,
    size: 1
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}