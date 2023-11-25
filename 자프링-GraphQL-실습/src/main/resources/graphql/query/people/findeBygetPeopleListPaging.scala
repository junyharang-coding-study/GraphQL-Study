query findeBygetPeopleListPaging {
  getPeopleList(
    page: 4,
    size: 10
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}