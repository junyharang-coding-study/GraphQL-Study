query findBygetPeopleListPaging {
  getPeopleList(peopleSearchRequestDto: {
    # teamId: 1,
    # lastName: "",
    # firstName: "",
    # sex: male,
    # bloodType: O,
    # serveYears: 1,
    # role: developer,
    # hometown: "California",
    pageNumber: 1,
    perPageSize: 5,
    # orderBy: true,
  }) {
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