query findBygetPeopleListSeachHometownAndPaging {
  getPeopleList(
    hometown: "California",
    page: 1,
    size: 5
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}