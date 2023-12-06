query findBygetPeopleListHometown {
  getPeopleList(peopleSearchRequestDto: {
    # teamId: 1,
    # lastName: "",
    # firstName: "",
    # sex: male,
    # bloodType: B,
    # serveYears: 1,
    # role: developer,
    hometown: "California",
    # page: 1,
    # perPageSize: 5,
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