query findBygetPeopleListSeachServeYearsAndPaging {
  getPeopleList(
    serveYears: 5,
    page: 1,
    size: 5
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}