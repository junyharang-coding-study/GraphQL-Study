query findBygetPeopleListSeachTeamIdAndPaging {
  getPeopleList(
    teamId: 1,
    page: 1,
    size: 5
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}