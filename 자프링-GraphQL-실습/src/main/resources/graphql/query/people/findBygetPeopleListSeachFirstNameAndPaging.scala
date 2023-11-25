query findBygetPeopleListSeachFirstNameAndPaging {
  getPeopleList(
    firstName: "Davidson",
    page: 1,
    size: 1
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}