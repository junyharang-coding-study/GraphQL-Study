query findBygetPeopleListSeachLastNameAndPaging {
  getPeopleList(
    lastName: "Alex",
    page: 1,
    size: 1
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}