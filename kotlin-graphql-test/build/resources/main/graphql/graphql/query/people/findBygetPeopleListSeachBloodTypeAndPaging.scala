query findBygetPeopleListSeachBloodTypeAndPaging {
  getPeopleList(
    bloodType: B,
    page: 1,
    size: 5
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}