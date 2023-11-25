query findBygetPeopleListSeachSexAndPaging {
  getPeopleList(
    sex: female,
    page: 1,
    size: 5
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}