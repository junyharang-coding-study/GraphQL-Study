query findBygetTeamListSeachMascotAndPaging {
  getTeamList(
    mascot: "Wildcat",
    page: 1,
    size: 1
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}