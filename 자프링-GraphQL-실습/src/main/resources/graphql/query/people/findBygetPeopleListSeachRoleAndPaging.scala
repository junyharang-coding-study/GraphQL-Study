query findBygetPeopleListSeachRoleAndPaging {
  getPeopleList(
    role: developer,
    page: 1,
    size: 5
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}