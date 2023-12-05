query findBygetPeopleListSeachBloodTypeAndPaging {
  getPeopleList(
    bloodType: B,
    page: 1,
    size: 5
  ) {
    statusCode,
    message,
    pagination {
      perPageSize,
      totalCount,
      totalPage,
      data {
        peopleId,
        teamId,
        lastName,
        firstName,
        sex,
        bloodType,
        serveYears,
        role,
        hometown
      }
    }
  }
}